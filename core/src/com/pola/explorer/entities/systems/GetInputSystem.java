package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.Bullet;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.HalfLifeComponent;
import com.pola.explorer.entities.components.MovementComponent;
import com.pola.explorer.entities.components.SpriteTexture;

public class GetInputSystem extends EntitySystem {
    private final Family getterInput = Family.all(MovementComponent.class, CollisionComponent.class).get();
    private ImmutableArray<Entity> entities;
    private final World world;

    public GetInputSystem(World world) {
        this.world = world;
    }

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
        for (Entity entity : entities) {
            MovementComponent movement = Mappers.movement.get(entity);
            SpriteTexture sprite = Mappers.spriteTexture.get(entity);
            CollisionComponent collision = Mappers.collision.get(entity);

            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                rotateTo(collision.body, -90);
                collision.body.setLinearVelocity(0, -movement.speed);
            } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                rotateTo(collision.body, 90);
                collision.body.setLinearVelocity(0, movement.speed);
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                rotateTo(collision.body, 180);
                collision.body.setLinearVelocity(-movement.speed, 0);
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                rotateTo(collision.body, 0);
                collision.body.setLinearVelocity(movement.speed, 0);
            } else {
                collision.body.setLinearVelocity(0, 0);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                Bullet bullet = new Bullet(sprite.sprite.getRotation(), 15, new Vector2(sprite.sprite.getX(), sprite.sprite.getY()), world);
                bullet.add(new HalfLifeComponent(5));
                getEngine().addEntity(bullet);

            }
        }
    }

    public void rotateTo(Body body, int degrees) {
        float initialAngle = body.getAngle();
        Gdx.app.log("Angle", String.valueOf(initialAngle));
        float delta = (float) (Math.toRadians(degrees) - initialAngle);
        delta += (delta > 180) ? -360 : ((delta < -180) ? 360 : 0);
        body.setAngularVelocity(delta * 4);
    }
}
