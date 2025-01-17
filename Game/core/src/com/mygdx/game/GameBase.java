package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.controlling.SoundsManager;
import com.mygdx.game.controlling.scores.ScoreManager;
import com.mygdx.game.util.interfaces.AdController;

public abstract class GameBase extends Game {

    private final AdController adController;

    private ScoreManager scoreManager;
    private SoundsManager soundsManager;

    private SpriteBatch batch;
    private AssetManager assetManager;

    public GameBase(AdController adController) {
        this.adController = adController;
        scoreManager = new ScoreManager();
    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        assetManager = new AssetManager();
        assetManager.getLogger().setLevel(Logger.DEBUG);
        soundsManager = new SoundsManager(assetManager);

        batch = new SpriteBatch();
        postCreate();
    }

    public abstract void postCreate();

    @Override
    public void dispose() {
        batch.dispose();
        assetManager.dispose();
        soundsManager.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public AdController getAdController() {
        return adController;
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    public SoundsManager getSoundsManager() {
        return soundsManager;
    }
}
