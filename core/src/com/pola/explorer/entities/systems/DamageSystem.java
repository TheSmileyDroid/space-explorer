package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.pola.explorer.entities.Mappers;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.LifeComponent;

public class DamageSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;
    private Family damageFamily = Family.all(LifeComponent.class).get();

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(damageFamily);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity :entities) {
            LifeComponent life = Mappers.life.get(entity);
            CollisionComponent collision = Mappers.collision.get(entity);

            if(life.life<=0){
                collision.body.getWorld().destroyBody(collision.body);
                entity.removeAll();
            }
        }
    }
}
