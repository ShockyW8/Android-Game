package com.mygdx.game.common;

public class Constants {

    public static final float WIDTH = 480f; // pixels
    public static final float HEIGHT = 800f; // pixels

    public static final float WORLD_WIDTH = 60f; // world units
    public static final float WORLD_HEIGHT = 100f; // world units

    public static final float HUD_WIDTH = 480f;
    public static final float HUD_HEIGHT = 800f;

    public static final float MENU_BUTTON_WIDTH = 240f;
    public static final float MENU_BUTTON_HEIGHT = MENU_BUTTON_WIDTH / 14f * 5f;
    public static final float TITLE_SIZE = 300f;

    public static final float[] HEARTS_POSITIONS = {90, 190, 290, 390};
    public static final float HEART_WIDTH = 70f;
    public static final float HEART_HEIGHT = HEART_WIDTH;

    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2f; // world units
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2f; // world units

    public static final float CELL_HEIGHT = 3.3f;
    public static final float MAX_SHADOW_SIZE = 3f;
    public static final float BONUS_WIDTH = 15f;
    public static final float BONUS_HEIGHT = BONUS_WIDTH;

    public static final long POT_FLIGHT_TIME = 1000;
    public static final long PLAYER_JUMP_TIME = 400;

    public static final float SIMPLE_POT_WIDTH = 10f;
    public static final float SIMPLE_POT_HEIGHT = SIMPLE_POT_WIDTH / 8f * 9.21f;
    public static final float SIMPLE_SMASH_WIDTH = 25f;
    public static final float SIMPLE_SMASH_HEIGHT = SIMPLE_SMASH_WIDTH / 12f * 9.02f;

    public static final float IRON_POT_WIDTH = 8f;
    public static final float IRON_POT_HEIGHT = IRON_POT_WIDTH * 1.05f;
    public static final float IRON_SMASH_WIDTH = 7.5f;
    public static final float IRON_SMASH_HEIGHT = IRON_SMASH_WIDTH / 8f * 4.39f;

    public static final float LARGE_POT_WIDTH = 22f;
    public static final float LARGE_POT_HEIGHT = LARGE_POT_WIDTH;
    public static final float LARGE_SMASH_WIDTH = 25f;
    public static final float LARGE_SMASH_HEIGHT = LARGE_SMASH_WIDTH;

    public static final float BONUS_POT_WIDTH = 8f;
    public static final float BONUS_POT_HEIGHT = BONUS_POT_WIDTH;
    public static final float BONUS_SMASH_WIDTH = 12f;
    public static final float BONUS_SMASH_HEIGHT = BONUS_SMASH_WIDTH;

    public static final float EXPLOSIVE_POT_WIDTH = 12f;
    public static final float EXPLOSIVE_POT_HEIGHT = EXPLOSIVE_POT_WIDTH;
    public static final float EXPLOSIVE_SMASH_WIDTH = 35f;
    public static final float EXPLOSIVE_SMASH_HEIGHT = EXPLOSIVE_SMASH_WIDTH;

    public static final float GRAN_X = 30f;
    public static final float GRAN_Y = 70f;
    public static final float GRAN_WIDTH = 30f;
    public static final float GRAN_HEIGHT = GRAN_WIDTH;
    public static final float GRAN_FRAME_TIME = 0.1f;

    public static final float PLAYER_WIDTH = 50f;
    public static final float PLAYER_HEIGHT = PLAYER_WIDTH;
    public static final float PLAYER_FRAME_TIME = PLAYER_JUMP_TIME / 1000f / 5f;

    public static final int START_LIVES_AMOUNT = 3;

    public static final float DEFAULT_POT_SPAWN_SPEED = 1f;
    public static final int CHANCE_FOR_RANDOM_TARGET = 5;

    public static final int SIMPLE_CENTRAL_DAMAGE = 3;
    public static final int LARGE_CENTRAL_DAMAGE = 3;
    public static final int EXPLOSIVE_CENTRAL_DAMAGE = 3;
    public static final int IRON_CENTRAL_DAMAGE = 4;
    public static final int SHARD_DAMAGE = 1;
    public static final int BONUS_DAMAGE = 3;

    public static final float POT_EXISTANCE_TIME = 0.3f;
    public static final float BONUS_EXISTANCE_TIME = 10f;

    public static final int LARGE_COOLDOWN = 8;
    public static final int EXPLOSIVE_COOLDOWN = 6;
    public static final int IRON_COOLDOWN = 4;
    public static final int BONUS_COOLDOWN = 3;

    public static final float GRID_TOP = 54f;
    public static final float GRID_TOP_WIDTH = 40f;
    public static final float Y_COEFFICIENT = 1.15f;
    public static final float X_COEFFICIENT = 1.09f;
    public static final float SIZE_COEFFICIENT = 1.1f;
    public static final float POT_SIZE_COEFFICIENT = 0.95f;

    public static final float FRAME_TIME = POT_EXISTANCE_TIME / 3;

    private Constants() {}
}
