package com.pola.explorer.entities;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.entities.systems.*;

/**
 *
 * @author gabriel
 */
public class SpaceEngine extends Engine {

    /**
     *
     * @param batch
     * @param world
     */
    public SpaceEngine(SpriteBatch batch, World world) {
        addSystem(new GetInputSystem(world));
        addSystem(new AutoMoveSystem());
        addSystem(new HalfLifeSystem());
        addSystem(new RenderSystem(batch));
        addSystem(new DamageSystem());
    }
}
