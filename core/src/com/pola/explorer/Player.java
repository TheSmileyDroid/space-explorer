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
public class Player extends Entity {

    /**
     *
     * @param world
     */
    public Player(World world) {
        Texture img = new Texture("spaceship.png");
        add(new SpriteTexture(img));
        add(new MovementComponent());
        add(new CollisionComponent(world, new Vector2(0, 0), (byte) 8, CollisionComponentType.PLAYER, this));
        add(new LifeComponent(10,100));
        add(new PlayerComponent());
        getComponent(MovementComponent.class)
                .setSpeed(40);
    }
}
