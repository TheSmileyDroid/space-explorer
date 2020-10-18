package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.HalfLifeComponent;

/**
 *
 * @author gabriel
 */
public class HalfLifeSystem extends EntitySystem {
    private final Family halfLifeFamily = Family.all(HalfLifeComponent.class).get();
    private ImmutableArray<Entity> entities;

    /**
     *
     * @param engine
     */
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(halfLifeFamily);
    }

    /**
     *
     * @param engine
     */
    @Override
    public void removedFromEngine(Engine engine) {
        entities = engine.getEntitiesFor(halfLifeFamily);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : entities) {
            HalfLifeComponent halfLife = Mappers.halfLife.get(entity);
            if (halfLife.time <= halfLife.halfLife) {
                halfLife.time += deltaTime;
            } else {
                getEngine().removeEntity(entity);
                CollisionComponent collision = Mappers.collision.get(entity);
                collision.body.getWorld().destroyBody(collision.body);
                entity.removeAll();
            }
        }
    }
}
