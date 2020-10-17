package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.components.AutoMovementComponent;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.SpriteTexture;

public class AutoMoveSystem extends EntitySystem {
    private final Family autoMove = Family.all(SpriteTexture.class, AutoMovementComponent.class, CollisionComponent.class).get();
    private ImmutableArray<Entity> entities;

    public AutoMoveSystem() {
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(autoMove);
    }

    @Override
    public void removedFromEngine(Engine engine) {
        entities = engine.getEntitiesFor(autoMove);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : entities) {
            AutoMovementComponent auto = Mappers.auto.get(entity);
            CollisionComponent collision = Mappers.collision.get(entity);

            collision.body.setLinearVelocity(auto.speed);
        }
    }
}
