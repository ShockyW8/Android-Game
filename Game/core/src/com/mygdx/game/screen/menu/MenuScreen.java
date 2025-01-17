package com.mygdx.game.screen.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AndroidGame;
import com.mygdx.game.assets.AssetDescriptors;
import com.mygdx.game.assets.RegionNames;
import com.mygdx.game.common.GameData;

public class MenuScreen extends MenuScreenBase {

    private TextureAtlas uiAtlas;

    public MenuScreen(AndroidGame game) {
        super(game);
        uiAtlas = assetManager.get(AssetDescriptors.UI_ATLAS);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        TextureRegion background = uiAtlas.findRegion(RegionNames.MENU_BACKGROUND);
        table.setBackground(new TextureRegionDrawable(background));

        TextButton playButton = createPlayButton();
        TextButton optionsButton = createOptionsButton();
        TextButton quitButton = createQuitButton();

        TextureRegionDrawable title = new TextureRegionDrawable(uiAtlas.findRegion(RegionNames.TITLE));
        Table titleTable = new Table();
        titleTable.setBackground(title);

        Table buttonTable = new Table(uiSkin);
        buttonTable.defaults().pad(20f);

        buttonTable.add(playButton).width(GameData.MENU_BUTTON_WIDTH).height(GameData.MENU_BUTTON_HEIGHT).row();
        buttonTable.add(optionsButton).width(GameData.MENU_BUTTON_WIDTH).height(GameData.MENU_BUTTON_HEIGHT).row();
        buttonTable.add(quitButton).width(GameData.MENU_BUTTON_WIDTH).height(GameData.MENU_BUTTON_HEIGHT);

        buttonTable.center();

        table.add(titleTable).width(GameData.TITLE_SIZE).height(GameData.TITLE_SIZE).row();
        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

    private TextButton createPlayButton() {
        TextButton playButton = new TextButton("PLAY", uiSkin);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                play();
            }
        });
        return playButton;
    }

    private TextButton createOptionsButton() {
        TextButton optionsButton = new TextButton("OPTIONS", uiSkin);
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                options();
            }
        });
        return optionsButton;
    }

    private TextButton createQuitButton() {
        TextButton quitButton = new TextButton("QUIT", uiSkin);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                quit();
            }
        });
        return quitButton;
    }

    private void play() {
        game.setScreen(new PlayScreen(game));
    }

    private void options() {
        game.setScreen(new OptionsScreen(game));
    }

    private void quit() {
        Gdx.app.exit();
    }
}
