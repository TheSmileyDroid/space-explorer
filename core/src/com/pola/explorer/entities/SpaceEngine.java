package com.pola.explorer.entities;

import com.badlogic.ashley.core.Engine;
import com.pola.explorer.entities.systems.AutoMoveSystem;
import com.pola.explorer.entities.systems.GetInputSystem;
import com.pola.explorer.entities.systems.HalfLifeSystem;

public class SpaceEngine extends Engine {
    public SpaceEngine(){
        addSystem(new GetInputSystem());
        addSystem(new AutoMoveSystem());
        addSystem(new HalfLifeSystem());
    }
}
