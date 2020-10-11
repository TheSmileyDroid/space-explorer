package com.pola.explorer;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.pola.explorer.components.HalfLifeComponent;

public class HalfLifeSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private Family halfLifeFamily = Family.all(HalfLifeComponent.class).get();

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(halfLifeFamily);
    }

    @Override
    public void removedFromEngine(Engine engine) {
        entities = engine.getEntitiesFor(halfLifeFamily);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : entities) {
            HalfLifeComponent halfLife = Mappers.halfLife.get(entity);
            if (halfLife.time<=halfLife.halfLife){
                halfLife.time += deltaTime;
            } else {
                getEngine().removeEntity(entity);
                entity.removeAll();
            }
        }
    }
}
