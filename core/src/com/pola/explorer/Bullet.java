package com.pola.explorer;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.entities.components.*;

public class Bullet extends Entity {
    public Bullet(float rotate, int speed, Vector2 position, World world) {
        add(new SpriteTexture(new Texture("spaceship.png")));
        add(new AutoMovementComponent(new Vector2(speed, 0).rotate(rotate)));
        add(new CollisionComponent(world, position, (byte) 8, CollisionComponentType.BULLET, this));
        add(new LifeComponent(1,1));
    }
}
