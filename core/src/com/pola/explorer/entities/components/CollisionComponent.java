package com.pola.explorer.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.pola.explorer.BodyData;

public class CollisionComponent implements Component {
    public Body body;

    public CollisionComponent(World world, Vector2 position, byte size, CollisionComponentType type, Entity entity) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size / 2, size / 2, new Vector2(size / 2, size / 2), 0);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Fixture fixture = body.createFixture(fixtureDef);

        body.setUserData(new BodyData(entity, type));

        shape.dispose();
    }
}
