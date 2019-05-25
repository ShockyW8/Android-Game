package com.mygdx.game.util;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.utils.ImmutableArray;
import com.mygdx.game.common.Mappers;
import com.mygdx.game.common.objects.Coordinates;
import com.mygdx.game.component.NumberComponent;
import com.mygdx.game.component.PositionComponent;
import com.mygdx.game.component.marking.CellComponent;

public class NumberConverter extends EntitySystem {

    private static final Family CELLS = Family.all(
            CellComponent.class,
            NumberComponent.class,
            PositionComponent.class
    ).get();
    private ImmutableArray<Entity> cells;

    public Coordinates getCoordinates(int xNumber, int yNumber) {
        cells = getEngine().getEntitiesFor(CELLS);
        for (Entity entity : cells) {
            NumberComponent number = Mappers.NUMBER.get(entity);
            if (xNumber == number.xNumber && yNumber == number.yNumber) {
                PositionComponent position = Mappers.POSITION.get(entity);
                return new Coordinates(position.x, position.y);
            }
        }
        return new Coordinates(0, 0);
    }

    public Coordinates getCoordinates(int xNumber, int yNumber, boolean left, boolean up) {
        cells = getEngine().getEntitiesFor(CELLS);
        float startX = 0;
        float startY = 0;
        float endX = 0;
        float endY = 0;
        float middleX = 0;
        float middleY = 0;

        for (Entity entity : cells) {
            NumberComponent number = Mappers.NUMBER.get(entity);

            if (xNumber == number.xNumber && yNumber == number.yNumber) {
                PositionComponent position = Mappers.POSITION.get(entity);
                startX = position.x;
                startY = position.y;
            }

            if (left && up && number.xNumber == xNumber - 1 && number.yNumber == yNumber - 1) {
                PositionComponent position = Mappers.POSITION.get(entity);
                endX = position.x;
                endY = position.y;
            } else if (left && !up && number.xNumber == xNumber - 1 && number.yNumber == yNumber + 1) {
                PositionComponent position = Mappers.POSITION.get(entity);
                endX = position.x;
                endY = position.y;
            } else if (!left && up && number.xNumber == xNumber + 1 && number.yNumber == yNumber - 1) {
                PositionComponent position = Mappers.POSITION.get(entity);
                endX = position.x;
                endY = position.y;
            } else if (!left && !up && number.xNumber == xNumber + 1 && number.yNumber == yNumber + 1) {
                PositionComponent position = Mappers.POSITION.get(entity);
                endX = position.x;
                endY = position.y;
            }
        }

        middleX = (startX + endX) / 2f;
        middleY = (startY + endY) / 2f;

        return new Coordinates(middleX, middleY);
    }
}