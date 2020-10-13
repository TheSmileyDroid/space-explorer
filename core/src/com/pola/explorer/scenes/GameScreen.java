package com.pola.explorer.scenes;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.Player;
import com.pola.explorer.SpaceContactListener;
import com.pola.explorer.SpaceExplorer;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.SpaceEngine;
import com.pola.explorer.entities.components.LifeComponent;
import com.pola.explorer.entities.components.SpriteTexture;

public class GameScreen implements Screen {

    OrthographicCamera camera;
    World world;
    SpriteBatch batch;
    Player player;
    Engine engine;
    Box2DDebugRenderer debugRenderer;
    Matrix4 matrix4;
    SpaceExplorer game;

    public GameScreen(SpaceExplorer game){
        this.game = game;
    }

    @Override
    public void show() {
        Box2D.init();
        world = new World(new Vector2(0, 0), true);
        camera = new OrthographicCamera(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch = new SpriteBatch();
        engine = new SpaceEngine(batch, world);
        player = new Player(world);
        engine.addEntity(player);
        debugRenderer = new Box2DDebugRenderer();
        debugRenderer.setDrawBodies(true);
        matrix4 = new Matrix4(camera.combined);
        world.setContactListener(new SpaceContactListener());
    }

    @Override
    public void render(float delta) {
        //Camera
        SpriteTexture spriteP = Mappers.spriteTexture.get(player);
        if (spriteP != null) {
            camera.position.x = spriteP.sprite.getX();
            camera.position.y = spriteP.sprite.getY();
        }
        camera.update();

        //Background
        Gdx.gl.glClearColor(0, 0, (float) 0.1, (float) 0.5);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        debugRenderer.render(world, batch.getProjectionMatrix());

        //Update
        batch.begin();
        engine.update(Gdx.graphics.getRawDeltaTime());
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        if (player.getComponent(LifeComponent.class) != null) {
            int vida = player.getComponent(LifeComponent.class).life;
            game.font.draw(batch, "vida: "+String.valueOf(vida)+"/"+String.valueOf(player.getComponent(LifeComponent.class).maxLife), 10, 10);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        engine.removeAllEntities();
    }
}
