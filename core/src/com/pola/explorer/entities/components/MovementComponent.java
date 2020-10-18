package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author gabriel
 */
public class MovementComponent implements Component {

    /**
     *
     */
    public float speed;

    /**
     *
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
