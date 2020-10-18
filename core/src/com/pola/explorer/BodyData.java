package com.pola.explorer;

import com.badlogic.ashley.core.Entity;
import com.pola.explorer.entities.components.CollisionComponentType;

/**
 *
 * @author gabriel
 */
public class BodyData {

    /**
     *
     */
    public Entity entity;

    /**
     *
     */
    public CollisionComponentType type;

    /**
     *
     * @param entity
     * @param type
     */
    public BodyData(Entity entity, CollisionComponentType type){
        this.entity = entity;
        this.type = type;
    }
}
