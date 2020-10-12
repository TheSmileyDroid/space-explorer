package com.pola.explorer;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.pola.explorer.entities.components.MovementComponent;
import com.pola.explorer.entities.components.SpriteTexture;

public class Player extends Entity {
    public Player() {
        Texture img = new Texture("spaceship.png");
        add(new SpriteTexture(img));
        add(new MovementComponent());
        getComponent(MovementComponent.class)
                .setSpeed(100);
    }
}
