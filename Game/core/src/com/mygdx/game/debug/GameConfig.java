package com.mygdx.game.debug;

public class GameConfig {

    public static final float WIDTH = 480f; // pixels
    public static final float HEIGHT = 800f; // pixels

    public static final float WORLD_WIDTH = 60f; // world units
    public static final float WORLD_HEIGHT = 100f; // world units

    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2f; // world units
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2f; // world units

    public static final float CELL_HEIGHT = 3.3f;
    public static final float PLAYER_SIZE = 7f;

    public static final int PLAYER_START_POSITION = 12;
    public static final int START_LIVES_AMOUNT = 3;

    public static final float DEFAULT_POT_SPAWN_SPEED = 0.5f;
    public static final long SHARD_EXISTANCE_TIME = 100;

    public static final int SIMPLE_CENTRAL_DAMAGE = 3;
    public static final int LARGE_CENTRAL_DAMAGE = 3;
    public static final int EXPLOSIVE_CENTRAL_DAMAGE = 3;
    public static final int IRON_CENTRAL_DAMAGE = 4;
    public static final int CAT_DAMAGE = 2;
    public static final int SHARD_DAMAGE = 1;

    public static final float COOLDOWN_INTERVAL = 1f;
    public static final int TRIPLE_COOLDOWN = 6;
    public static final int LARGE_COOLDOWN = 6;
    public static final int EXPLOSIVE_COOLDOWN = 6;
    public static final int IRON_COOLDOWN = 6;
    public static final int CAT_COOLDOWN = 6;

    public static final float GRID_TOP = 54f;
    public static final float GRID_TOP_WIDTH = 40f;
    public static final float Y_COEFFICIENT = 1.15f;
    public static final float X_COEFFICIENT = 1.09f;

    private GameConfig() {}
}
