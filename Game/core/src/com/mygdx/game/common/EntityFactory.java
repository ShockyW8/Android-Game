package com.mygdx.game.common;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.component.AttackStateComponent;
import com.mygdx.game.component.BoundsComponent;
import com.mygdx.game.component.CellComponent;
import com.mygdx.game.component.MovementStateComponent;
import com.mygdx.game.component.NumberComponent;
import com.mygdx.game.component.PlayerComponent;
import com.mygdx.game.component.PositionComponent;
import com.mygdx.game.component.PositionOnGridComponent;
import com.mygdx.game.debug.GameConfig;
import com.mygdx.game.system.debug.PositionsCalculationSystem;

public class EntityFactory {

    private final PooledEngine engine;
    private final AssetManager assetManager;

    public EntityFactory(PooledEngine engine, AssetManager assetManager) {
        this.engine = engine;
        this.assetManager = assetManager;
    }

    public void addCell(float x, float y, int xNumber, int yNumber, float height) {
        PositionComponent position = engine.createComponent(PositionComponent.class);
        position.x = x;
        position.y = y;

        NumberComponent numberComponent = engine.createComponent(NumberComponent.class);
        numberComponent.xNumber = xNumber;
        numberComponent.yNumber = yNumber;

        BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
        bounds.bounds.set(x, y, height * 2, height);

        CellComponent cellComponent = engine.createComponent(CellComponent.class);

        AttackStateComponent attackState = engine.createComponent(AttackStateComponent.class);
        attackState.damage = 0;

        Entity entity = engine.createEntity();
        entity.add(position);
        entity.add(bounds);
        entity.add(cellComponent);
        entity.add(attackState);
        entity.add(numberComponent);

        engine.addEntity(entity);
    }

    public void addPlayer() {
        PositionOnGridComponent position = engine.createComponent(PositionOnGridComponent.class);
        position.xNumber = engine.getSystem(PositionsCalculationSystem.class).positions.length / 2;
        position.yNumber = engine.getSystem(PositionsCalculationSystem.class).positions[0].length / 2;

        BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
        bounds.bounds.set(
                engine.getSystem(PositionsCalculationSystem.class).positions[position.xNumber][position.yNumber][0],
                engine.getSystem(PositionsCalculationSystem.class).positions[position.xNumber][position.yNumber][1],
                GameConfig.PLAYER_SIZE,
                GameConfig.PLAYER_SIZE
        );

        MovementStateComponent movementState = engine.createComponent(MovementStateComponent.class);
        movementState.setMoving(false);

        PlayerComponent player = engine.createComponent(PlayerComponent.class);

        Entity entity = engine.createEntity();
        entity.add(position);
        entity.add(bounds);
        entity.add(player);
        entity.add(movementState);

        engine.addEntity(entity);
    }
}
