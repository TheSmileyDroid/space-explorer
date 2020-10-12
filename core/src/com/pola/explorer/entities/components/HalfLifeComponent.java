package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;

public class HalfLifeComponent implements Component {
    public float halfLife;
    public float time = 0;

    public HalfLifeComponent(float halfLife) {
        this.halfLife = halfLife;
    }
}
