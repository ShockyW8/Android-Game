package com.mygdx.game.system.debug;

import com.badlogic.ashley.core.EntitySystem;
import com.mygdx.game.common.GameData;
import com.mygdx.game.common.EntityFactory;

public class CellsSpawnSystem extends EntitySystem {

    private final EntityFactory factory;

    public CellsSpawnSystem(EntityFactory factory) {
        this.factory = factory;
    }

    public void spawnCells(int x, int y) {
        float[][][] positions = getEngine().getSystem(PositionsCalculationSystem.class).positions;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                factory.addCell(positions[i][j][0], positions[i][j][1], i, j, GameData.CELL_HEIGHT * (float) Math.pow(GameData.SIZE_COEFFICIENT, j));
            }
        }
    }
}
