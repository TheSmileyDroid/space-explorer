package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author gabriel
 */
public class LifeComponent implements Component {

    /**
     *
     */
    public int life;

    /**
     *
     */
    public int maxLife;

    /**
     *
     * @param life
     * @param maxLife
     */
    public LifeComponent(int life, int maxLife) {
        this.life = life;
        this.maxLife = maxLife;
    }
}
