package com.pola.explorer.entities;

import com.badlogic.ashley.core.ComponentMapper;
import com.pola.explorer.entities.components.*;

/**
 *
 * @author gabriel
 */
public class Mappers {

    /**
     *
     */
    public static final ComponentMapper<SpriteTexture> spriteTexture = ComponentMapper.getFor(SpriteTexture.class);

    /**
     *
     */
    public static final ComponentMapper<MovementComponent> movement = ComponentMapper.getFor(MovementComponent.class);

    /**
     *
     */
    public static final ComponentMapper<AutoMovementComponent> auto = ComponentMapper.getFor(AutoMovementComponent.class);

    /**
     *
     */
    public static final ComponentMapper<HalfLifeComponent> halfLife = ComponentMapper.getFor(HalfLifeComponent.class);

    /**
     *
     */
    public static final ComponentMapper<LifeComponent> life = ComponentMapper.getFor(LifeComponent.class);

    /**
     *
     */
    public static final ComponentMapper<CollisionComponent> collision = ComponentMapper.getFor(CollisionComponent.class);


}
