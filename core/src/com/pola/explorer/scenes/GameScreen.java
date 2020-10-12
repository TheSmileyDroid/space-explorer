package com.pola.explorer.scenes;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pola.explorer.Bullet;
import com.pola.explorer.Player;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.SpaceEngine;
import com.pola.explorer.entities.components.HalfLifeComponent;
import com.pola.explorer.entities.components.SpriteTexture;
import com.pola.explorer.entities.systems.AutoMoveSystem;
import com.pola.explorer.entities.systems.GetInputSystem;
import com.pola.explorer.entities.systems.HalfLifeSystem;

public class GameScreen implements Screen {

    OrthographicCamera camera;
    SpriteBatch batch;
    Player player;
    Engine engine = new SpaceEngine();
    Family drawable = Family.all(SpriteTexture.class)
            .get();

    @Override
    public void show() {
        camera = new OrthographicCamera(400, 300);
        Bullet bullet = new Bullet(0, 50, new Vector2(0, 0));
        bullet.add(new HalfLifeComponent(2));
        engine.addEntity(bullet);
        player = new Player();
        engine.addEntity(player);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        engine.update(Gdx.graphics.getRawDeltaTime());
        SpriteTexture spriteP = Mappers.spriteTexture.get(player);
        camera.position.x = spriteP.sprite.getX();
        camera.position.y = spriteP.sprite.getY();
        camera.update();
        Gdx.gl.glClearColor(0, 0, (float) 0.1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        ImmutableArray<Entity> desenhavel = engine.getEntitiesFor(drawable);
        for (Entity entity : desenhavel) {
            SpriteTexture texP = Mappers.spriteTexture.get(entity);
            texP.sprite.draw(batch);
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
