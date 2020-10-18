package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author gabriel
 */
public class SpriteTexture implements Component {

    /**
     *
     */
    public Texture texture;

    /**
     *
     */
    public Sprite sprite;

    /**
     *
     * @param texture
     */
    public SpriteTexture(Texture texture) {
        this.texture = texture;
        sprite = new Sprite(texture);
        sprite.setPosition(0, 0);
    }

    /**
     *
     * @param texture
     */
    public void setSprite(Texture texture) {
        this.texture = texture;
        sprite.setTexture(texture);
    }

}
