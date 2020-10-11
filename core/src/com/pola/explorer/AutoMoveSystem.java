package com.pola.explorer;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.pola.explorer.components.AutoMovementComponent;
import com.pola.explorer.components.SpriteTexture;

public class AutoMoveSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private Family autoMove = Family.all(SpriteTexture.class, AutoMovementComponent.class).get();

    public AutoMoveSystem(){}

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
            SpriteTexture sprite = Mappers.spriteTexture.get(entity);
            AutoMovementComponent auto = Mappers.auto.get(entity);
            sprite.sprite.translate(auto.speed.x*deltaTime,auto.speed.y*deltaTime);
        }
    }
}
