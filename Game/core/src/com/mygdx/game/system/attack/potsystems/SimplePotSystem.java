package com.mygdx.game.system.attack.potsystems;

import com.badlogic.ashley.core.Entity;
import com.mygdx.game.common.GameData;
import com.mygdx.game.common.Mappers;
import com.mygdx.game.common.enums.PotType;
import com.mygdx.game.component.PositionOnGridComponent;
import com.mygdx.game.screen.game.BasicGameScreen;
import com.mygdx.game.util.services.ObjectCreator;

public class SimplePotSystem extends PotSystem {

    public SimplePotSystem(int x, int y, BasicGameScreen screen) {
        super(screen, PotType.SIMPLE, x, y);
    }

    @Override
    public void attack() {
        for (int i = 0; i < cells.size(); i++) {
            Entity cell = cells.get(i);
            PositionOnGridComponent positionOnGrid = Mappers.POSITION_ON_GRID.get(cell);

            if (positionOnGrid.xNumber == x) {

                if (positionOnGrid.yNumber == y) {
                    ObjectCreator.createDamageObject(cell, GameData.SIMPLE_CENTRAL_DAMAGE, GameData.POT_EXISTENCE_TIME);
                } else if (positionOnGrid.yNumber == y - 1) {
                    ObjectCreator.createDamageObject(cell, GameData.SHARD_DAMAGE, GameData.POT_EXISTENCE_TIME);
                } else if (positionOnGrid.yNumber == y + 1) {
                    ObjectCreator.createDamageObject(cell, GameData.SHARD_DAMAGE, GameData.POT_EXISTENCE_TIME);
                }

            }

            if (positionOnGrid.yNumber == y) {

                if (positionOnGrid.xNumber == x - 1) {
                    ObjectCreator.createDamageObject(cell, GameData.SHARD_DAMAGE, GameData.POT_EXISTENCE_TIME);
                } else if (positionOnGrid.xNumber == x + 1) {
                    ObjectCreator.createDamageObject(cell, GameData.SHARD_DAMAGE, GameData.POT_EXISTENCE_TIME);
                }

            }
        }
        screen.potThrown();
        engine.removeSystem(this);
    }
}
