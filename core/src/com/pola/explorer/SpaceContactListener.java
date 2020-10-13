package com.pola.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.pola.explorer.entities.components.CollisionComponentType;
import com.pola.explorer.entities.components.LifeComponent;

public class SpaceContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        Body bodyA = fixtureA.getBody();
        Body bodyB = fixtureB.getBody();
        if (bodyA.getUserData().getClass() == BodyData.class || bodyB.getUserData().getClass() == BodyData.class) {
            BodyData dataA = (BodyData) bodyA.getUserData();
            BodyData dataB = (BodyData) bodyB.getUserData();
            if ((dataA.type == CollisionComponentType.BULLET || dataB.type == CollisionComponentType.BULLET)){
                Gdx.app.log("Colisão", "Houve um tiro");
                dataA.entity.getComponent(LifeComponent.class).life -= 1;
                dataB.entity.getComponent(LifeComponent.class).life -= 1;
            }
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
