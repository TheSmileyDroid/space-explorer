package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.Bullet;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.HalfLifeComponent;
import com.pola.explorer.entities.components.MovementComponent;
import com.pola.explorer.entities.components.SpriteTexture;

/**
 *
 * @author gabriel
 */
public class GetInputSystem extends EntitySystem {
    private final Family getterInput = Family.all(MovementComponent.class, CollisionComponent.class).get();
    private ImmutableArray<Entity> entities;
    private final World world;

    /**
     *
     * @param world
     */
    public GetInputSystem(World world) {
        this.world = world;
    }

    /**
     *
     * @param engine
     */
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(getterInput);
    }

    /**
     *
     * @param engine
     */
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
                Vector2 speedDirection = new Vector2(movement.speed, 0)
                        .rotate(sprite.sprite.getRotation()+180);
                collision.body.setLinearVelocity(speedDirection);
            } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                Vector2 speedDirection = new Vector2(movement.speed, 0)
                        .rotate(sprite.sprite.getRotation());
                collision.body.setLinearVelocity(speedDirection);
            } else {
                collision.body.setLinearVelocity(0, 0);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                collision.body.setAngularVelocity(2);
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                collision.body.setAngularVelocity(-2);
            } else {
                collision.body.setAngularVelocity(0);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                Vector2 posi = collision.body.getWorldCenter();
                Vector2 dir = new Vector2(16,0).rotate(sprite.sprite.getRotation());
                Vector2 nPosi = new Vector2(posi.x+dir.x,posi.y+dir.y);
                Bullet bullet = new Bullet(sprite.sprite.getRotation(), 80, nPosi, world);
                bullet.add(new HalfLifeComponent(3));
                getEngine().addEntity(bullet);

            }
        }
    }
}
