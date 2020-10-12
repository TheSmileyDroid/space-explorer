package com.pola.explorer;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.pola.explorer.entities.components.AutoMovementComponent;
import com.pola.explorer.entities.components.SpriteTexture;

public class Bullet extends Entity {
    public Bullet(float rotate, int speed, Vector2 position) {
        add(new SpriteTexture(new Texture("spaceship.png")));
        add(new AutoMovementComponent(new Vector2(1 * speed, 0).rotate(rotate)));
        getComponent(SpriteTexture.class).sprite.setPosition(position.x, position.y);
    }
}
