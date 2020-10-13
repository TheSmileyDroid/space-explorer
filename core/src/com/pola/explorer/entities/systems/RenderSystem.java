package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.SpriteTexture;

public class RenderSystem extends EntitySystem {
    private final Family desenhavel = Family.all(SpriteTexture.class, CollisionComponent.class).get();
    public SpriteBatch batch;
    private ImmutableArray<Entity> entities;

    public RenderSystem(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(desenhavel);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : entities) {
            CollisionComponent collision = Mappers.collision.get(entity);
            SpriteTexture texture = Mappers.spriteTexture.get(entity);

            texture.sprite.setOriginBasedPosition(collision.body.getWorldCenter().x, collision.body.getWorldCenter().y);
            texture.sprite.setRotation((float) Math.toDegrees(collision.body.getAngle()));

            texture.sprite.draw(batch);
        }
    }
}
