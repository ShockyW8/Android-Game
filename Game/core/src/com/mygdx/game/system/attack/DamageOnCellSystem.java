package com.mygdx.game.system.attack;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.mygdx.game.common.GameManager;
import com.mygdx.game.common.Mappers;
import com.mygdx.game.component.AttackStateComponent;
import com.mygdx.game.component.NumberComponent;
import com.mygdx.game.component.PositionOnGridComponent;

public class DamageOnCellSystem extends IteratingSystem {

    private static final Family PLAYERS = Family.all(
            PositionOnGridComponent.class
    ).get();

    private static final Family CELLS = Family.all(
            AttackStateComponent.class
    ).get();

    public DamageOnCellSystem() {
        super(PLAYERS);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ImmutableArray<Entity> cells = getEngine().getEntitiesFor(CELLS);

        PositionOnGridComponent position = Mappers.POSITION_ON_GRID.get(entity);
         for (Entity cell : cells) {
             NumberComponent numberComponent = Mappers.NUMBER.get(cell);
             if (numberComponent.xNumber == position.xNumber && numberComponent.yNumber == position.yNumber) {
                 AttackStateComponent attackState = Mappers.ATTACK_STATE.get(cell);
                 GameManager.INSTANCE.takeDamage(attackState.damage);
                 attackState.damage = 0;
                 return;
             }
         }
    }
}