package com.pola.explorer.entities.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.pola.explorer.entities.components.CollisionComponent;
import com.pola.explorer.entities.components.EnemyAiComponent;
import com.pola.explorer.entities.components.MovementComponent;
import com.pola.explorer.entities.components.PlayerComponent;

public class EnemyAiSystem extends EntitySystem {
    private final Family ai =
            Family.all(
                    MovementComponent.class,
                    CollisionComponent.class,
                    EnemyAiComponent.class
            ).get();
}
