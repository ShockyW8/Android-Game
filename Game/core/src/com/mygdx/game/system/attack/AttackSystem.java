package com.mygdx.game.system.attack;

import com.badlogic.ashley.systems.IntervalSystem;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.common.GameManager;
import com.mygdx.game.debug.PotType;
import com.mygdx.game.screen.game.EndlessModeScreen;

import java.util.HashMap;
import java.util.Map;

public class AttackSystem extends IntervalSystem {

    private static final Logger log = new Logger(AttackSystem.class.getName(), Logger.DEBUG);
    private EndlessModeScreen screen;
    private Map<PotType, Integer> priorities;

    public AttackSystem(float attackSpeed, EndlessModeScreen screen) {
        super(attackSpeed);
        this.screen = screen;
        priorities = new HashMap<PotType, Integer>();
        priorities.put(PotType.SIMPLE, 0);
        priorities.put(PotType.LARGE, 1);
        priorities.put(PotType.IRON, 2);
        priorities.put(PotType.CAT, 3);
        priorities.put(PotType.EXPLOSIVE, 4);
    }

    @Override
    protected void updateInterval() {
        PotType type = selectPotType();
        int x = getEngine().getSystem(TargetSystem.class).selectTargetX();
        int y = getEngine().getSystem(TargetSystem.class).selectTargetY();

        if (type == PotType.SIMPLE) {
            SimplePotSystem simplePotSystem = new SimplePotSystem(x, y);
            getEngine().addSystem(simplePotSystem);
            Thread thread = new Thread(simplePotSystem);
            thread.start();
        } else if (type == PotType.LARGE) {
            LargePotSystem largePotSystem = new LargePotSystem(x, y);
            getEngine().addSystem(largePotSystem);
            Thread thread = new Thread(largePotSystem);
            thread.start();
        } else if (type == PotType.EXPLOSIVE) {
            ExplosivePotSystem explosivePotSystem = new ExplosivePotSystem(x, y);
            getEngine().addSystem(explosivePotSystem);
            Thread thread = new Thread(explosivePotSystem);
            thread.start();
        } else if (type == PotType.IRON) {
            IronPotSystem ironPotSystem = new IronPotSystem(x, y);
            getEngine().addSystem(ironPotSystem);
            Thread thread = new Thread(ironPotSystem);
            thread.start();
        } else if (type == PotType.CAT) {
            CatSystem catSystem = new CatSystem(screen, x);
            getEngine().addSystem(catSystem);
            Thread thread = new Thread(catSystem);
            thread.start();
        }
    }

    private PotType selectPotType() {
        PotType type = PotType.SIMPLE;

        for (PotType type1 : priorities.keySet()) {
            if (priorities.get(type) < priorities.get(type1) && GameManager.INSTANCE.getCooldown(type1) == 0) {
                type = type1;
            }
        }

        log.debug("type = " + type);
        GameManager.INSTANCE.decrementCooldowns();
        GameManager.INSTANCE.resetCooldown(type);
        return type;
    }
}
