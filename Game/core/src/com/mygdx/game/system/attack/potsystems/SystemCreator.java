package com.mygdx.game.system.attack.potsystems;

import com.badlogic.ashley.core.PooledEngine;
import com.mygdx.game.common.objects.BonusType;
import com.mygdx.game.screen.BasicGameScreen;

public class SystemCreator {

    public static void createSimplePotSystem(PooledEngine engine, BasicGameScreen screen, int x, int y) {
        SimplePotSystem simplePotSystem = new SimplePotSystem(x, y, engine, screen);
        engine.addSystem(simplePotSystem);
        Thread thread = new Thread(simplePotSystem);
        thread.start();
    }

    public static void createIronPotSystem(PooledEngine engine, int x, int y) {
        IronPotSystem ironPotSystem = new IronPotSystem(x, y, engine);
        engine.addSystem(ironPotSystem);
        Thread thread = new Thread(ironPotSystem);
        thread.start();
    }

    public static void createLargePotSystem(PooledEngine engine, int x, int y) {
        LargePotSystem largePotSystem = new LargePotSystem(x, y, engine);
        engine.addSystem(largePotSystem);
        Thread thread = new Thread(largePotSystem);
        thread.start();
    }

    public static void createExplosivePotSystem(PooledEngine engine, int x, int y) {
        ExplosivePotSystem explosivePotSystem = new ExplosivePotSystem(x, y, engine);
        engine.addSystem(explosivePotSystem);
        Thread thread = new Thread(explosivePotSystem);
        thread.start();
    }

    public static void createCatSystem(PooledEngine engine, BasicGameScreen screen, int x) {
        CatSystem catSystem = new CatSystem(screen, x, engine);
        engine.addSystem(catSystem);
        Thread thread = new Thread(catSystem);
        thread.start();
    }

    public static void createBonusPotSystem(PooledEngine engine, BonusType type, int x, int y) {
        BonusPotSystem bonusPotSystem = new BonusPotSystem(x, y, type);
        engine.addSystem(bonusPotSystem);
        Thread thread = new Thread(bonusPotSystem);
        thread.start();
    }

    private SystemCreator() {
    }

}