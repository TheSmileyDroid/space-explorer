package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;

public class LifeComponent implements Component {
    public int life;
    public int maxLife;

    public LifeComponent(int life, int maxLife){
        this.life = life;
        this.maxLife = maxLife;
    }
}
