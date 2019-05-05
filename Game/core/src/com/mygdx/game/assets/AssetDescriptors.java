package com.mygdx.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetDescriptors {

    public static final AssetDescriptor<TextureAtlas> GAMEPLAY_BG =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GAMEPLAY_BACKGROUND, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> SIMPLE_TEXTURE =
            new AssetDescriptor<TextureAtlas>(AssetPaths.SIMPLE_POT_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.FONT, BitmapFont.class);

    public static final AssetDescriptor<Sound> FUMAR_SOUND =
            new AssetDescriptor<Sound>(AssetPaths.FUMAR_SOUND, Sound.class);

    public static final AssetDescriptor<TextureAtlas> GRAN_LOADING_ANIMATION =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GRAN_LOADING_ANIMATION, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> LOADING_BACKGROUND =
            new AssetDescriptor<TextureAtlas>(AssetPaths.LOADING_BACKGROUND, TextureAtlas.class);

    private AssetDescriptors() {}
}