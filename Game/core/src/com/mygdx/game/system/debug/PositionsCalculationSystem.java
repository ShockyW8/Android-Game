package com.mygdx.game.system.debug;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.common.GameData;

public class PositionsCalculationSystem extends EntitySystem {

    public float[][][] positions;
    private static final Logger log = new Logger(PositionsCalculationSystem.class.getName(), Logger.DEBUG);

    public PositionsCalculationSystem(int x, int y) {
        positions = new float[x][y][2];
        calculatePositions(x, y);
    }

    private float[][][] calculatePositions(int x, int y) {
        float yDistance = startYDistance(y);
        float defDistance = 0;

        //calculating y`s
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                positions[j][i][1] =
                        GameData.GRID_TOP - defDistance - yDistance * (float) Math.pow(GameData.Y_COEFFICIENT, i);
            }
            defDistance += yDistance * (float) Math.pow(GameData.Y_COEFFICIENT, i);
        }

        //calculate x`s
        for (int i = 0; i < y; i++) {
            float distance = (float) (startXDistance(x) * Math.pow(GameData.X_COEFFICIENT, i));
//            log.debug("distance = " + distance);
            float startX = rowStartX(distance, x);
            for (int j = 0; j < x; j++) {
                positions[j][i][0] =
                        startX + distance * j;
            }
        }

        return positions;
    }

    private float startYDistance(int y) {
        return (float) (4.2f / (Math.pow(GameData.Y_COEFFICIENT, y) - 1));
    }

    private float startXDistance(int x) {
//        log.debug("start x distance = " + GameData.GRID_TOP_WIDTH / x);
        return GameData.GRID_TOP_WIDTH / x;
    }

    private float rowStartX(float distance, int x) {
//        log.debug("row start x = " + (GameData.WORLD_WIDTH / 2f - (x / 2f) * distance));
        return GameData.WORLD_WIDTH / 2f - (x / 2f - 0.5f) * distance;
    }
}
