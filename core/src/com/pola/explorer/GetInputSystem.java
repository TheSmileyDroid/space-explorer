package com.pola.explorer;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.pola.explorer.components.HalfLifeComponent;
import com.pola.explorer.components.MovementComponent;
import com.pola.explorer.components.SpriteTexture;

public class GetInputSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private Family getterInput = Family.all(MovementComponent.class).get();

    private Interpolation inter = Interpolation.bounce;
    private float duration = 2;
    private float elapsed = 0;

    public GetInputSystem(){}

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(getterInput);
    }

    @Override
    public void removedFromEngine(Engine engine) {
        entities = engine.getEntitiesFor(getterInput);
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            for (Entity entity : entities) {
                MovementComponent movement = Mappers.movement.get(entity);
                SpriteTexture sprite = Mappers.spriteTexture.get(entity);
                sprite.sprite.setRotation(-90);
                sprite.sprite.translate(0,-deltaTime*movement.speed);

            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            for (Entity entity : entities) {
                MovementComponent movement = Mappers.movement.get(entity);
                SpriteTexture sprite = Mappers.spriteTexture.get(entity);
                sprite.sprite.setRotation(90);
                sprite.sprite.translate(0,deltaTime*movement.speed);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            for (Entity entity : entities) {
                MovementComponent movement = Mappers.movement.get(entity);
                SpriteTexture sprite = Mappers.spriteTexture.get(entity);
                sprite.sprite.setRotation(-180);
                sprite.sprite.translate(-deltaTime*movement.speed,0);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            for (Entity entity : entities) {
                MovementComponent movement = Mappers.movement.get(entity);
                SpriteTexture sprite = Mappers.spriteTexture.get(entity);
                sprite.sprite.setRotation(0);
                sprite.sprite.translate(deltaTime*movement.speed,0);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            for (Entity entity : entities) {
                SpriteTexture sprite = Mappers.spriteTexture.get(entity);
                Bullet bullet = new Bullet(sprite.sprite.getRotation(), 50, new Vector2(sprite.sprite.getX(),sprite.sprite.getY()));
                bullet.add(new HalfLifeComponent(5));
                getEngine().addEntity(bullet);
            }
        }
    }
}
