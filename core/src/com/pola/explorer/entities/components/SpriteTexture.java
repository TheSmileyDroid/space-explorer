package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteTexture implements Component {

    public Texture texture;
    public Sprite sprite;

    public SpriteTexture(Texture texture) {
        this.texture = texture;
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
    }

    public void setSprite(Texture texture) {
        this.texture = texture;
        sprite.setTexture(texture);
    }

}
