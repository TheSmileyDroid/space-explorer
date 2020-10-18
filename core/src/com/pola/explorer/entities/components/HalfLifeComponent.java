package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author gabriel
 */
public class HalfLifeComponent implements Component {

    /**
     *
     */
    public float halfLife;

    /**
     *
     */
    public float time = 0;

    /**
     *
     * @param halfLife
     */
    public HalfLifeComponent(float halfLife) {
        this.halfLife = halfLife;
    }
}
