package com.pola.explorer;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.entities.components.*;

/**
 *
 * @author gabriel
 */
public class Bullet extends Entity {

    /**
     *
     * @param rotate
     * @param speed
     * @param position
     * @param world
     */
    public Bullet(float rotate, int speed, Vector2 position, World world) {
        add(new SpriteTexture(new Texture("bulletSprite.png")));
        add(new AutoMovementComponent(new Vector2(speed, 0).rotate(rotate)));
        add(new CollisionComponent(world, position, (byte) 4, CollisionComponentType.BULLET, this));
        getComponent(CollisionComponent.class).body.setTransform(getComponent(CollisionComponent.class).body.getPosition(), (float) Math.toRadians(rotate));
        add(new LifeComponent(1,1));
    }
}
