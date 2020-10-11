package com.pola.explorer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.pola.explorer.components.*;

public class SpaceExplorer extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img;
	Player player;
	Engine engine = new Engine();
	Family drawable = Family.all(SpriteTexture.class)
			.get();

	@Override
	public void create () {
		camera = new OrthographicCamera(400,300);
		engine.addSystem(new GetInputSystem());
		engine.addSystem(new AutoMoveSystem());
		engine.addSystem(new HalfLifeSystem());
		Bullet bullet = new Bullet(0, 50, new Vector2(0,0));
		bullet.add(new HalfLifeComponent(2));
		engine.addEntity(bullet);
		player = new Player();
		engine.addEntity(player);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}



	@Override
	public void render () {
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
		for (Entity entity :desenhavel) {
			SpriteTexture texP = Mappers.spriteTexture.get(entity);
			texP.sprite.draw(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
