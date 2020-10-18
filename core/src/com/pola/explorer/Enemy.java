/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pola.explorer;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.CollisionComponentType;
import com.pola.explorer.entities.components.LifeComponent;
import com.pola.explorer.entities.components.MovementComponent;
import com.pola.explorer.entities.components.SpriteTexture;

/**
 *
 * @author gabriel
 */
public class Enemy extends Entity{
    
    /**
     *
     * @param world
     */
    public Enemy(World world) {
        Texture img = new Texture("spaceship.png");
        add(new SpriteTexture(img));
        add(new MovementComponent());
        add(new CollisionComponent(world, new Vector2(40, 40), (byte) 8, CollisionComponentType.ENEMY, this));
        add(new LifeComponent(10,100));
        getComponent(MovementComponent.class)
                .setSpeed(40);
    }
}
