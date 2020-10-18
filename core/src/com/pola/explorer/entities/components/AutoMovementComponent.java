package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author gabriel
 */
public class AutoMovementComponent implements Component {

    /**
     *
     */
    public Vector2 speed;

    /**
     *
     * @param speed
     */
    public AutoMovementComponent(Vector2 speed) {
        this.speed = speed;
    }
}
