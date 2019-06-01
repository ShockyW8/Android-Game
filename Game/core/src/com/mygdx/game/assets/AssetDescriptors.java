package com.mygdx.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetDescriptors {

    public static final AssetDescriptor<TextureAtlas> GAMEPLAY_BG =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GAMEPLAY_BACKGROUND, TextureAtlas.class);

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.FONT, BitmapFont.class);

    public static final AssetDescriptor<Sound> FUMAR_SOUND =
            new AssetDescriptor<Sound>(AssetPaths.FUMAR_SOUND, Sound.class);

    public static final AssetDescriptor<TextureAtlas> GRAN_LOADING_ANIMATION =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GRAN_LOADING_ANIMATION, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> LOADING_BACKGROUND =
            new AssetDescriptor<TextureAtlas>(AssetPaths.LOADING_BACKGROUND, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> SIMPLE_TEXTURE =
            new AssetDescriptor<TextureAtlas>(AssetPaths.SIMPLE_POT_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> SIMPLE_SMASH =
            new AssetDescriptor<TextureAtlas>(AssetPaths.SIMPLE_SMASH_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> IRON_TEXTURE =
            new AssetDescriptor<TextureAtlas>(AssetPaths.IRON_POT_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> IRON_SMASH =
            new AssetDescriptor<TextureAtlas>(AssetPaths.IRON_SMASH_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> LARGE_TEXTURE =
            new AssetDescriptor<TextureAtlas>(AssetPaths.LARGE_POT_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> LARGE_SMASH =
            new AssetDescriptor<TextureAtlas>(AssetPaths.LARGE_SMASH_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> BONUS_TEXTURE =
            new AssetDescriptor<TextureAtlas>(AssetPaths.BONUS_POT_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> BONUS_SMASH =
            new AssetDescriptor<TextureAtlas>(AssetPaths.BONUS_SMASH_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> EXPLOSIVE_TEXTURE =
            new AssetDescriptor<TextureAtlas>(AssetPaths.EXPLOSIVE_POT_TEXTURE, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> EXPLOSIVE_SMASH =
            new AssetDescriptor<TextureAtlas>(AssetPaths.EXPLOSIVE_SMASH_TEXTURE, TextureAtlas.class);

//    public static final AssetDescriptor<TextureAtlas> CAT_FLIGHT =
//            new AssetDescriptor<TextureAtlas>(AssetPaths.CAT_FLIGHT_TEXTURE, TextureAtlas.class);
//
//    public static final AssetDescriptor<TextureAtlas> CAT_SMASH =
//            new AssetDescriptor<TextureAtlas>(AssetPaths.CAT_SMASH_TEXTURE, TextureAtlas.class);
//
//    public static final AssetDescriptor<TextureAtlas> CAT_STATIC =
//            new AssetDescriptor<TextureAtlas>(AssetPaths.CAT_STATIC, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> GRAN_SIMPLE_THROW =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GRAN_SIMPLE_THROW, TextureAtlas.class);

    public static final AssetDescriptor<Texture> GRAN_STATIC =
            new AssetDescriptor<Texture>(AssetPaths.GRAN_STATIC, Texture.class);

    public static final AssetDescriptor<TextureAtlas> GRAN_IRON_THROW =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GRAN_IRON_THROW, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> GRAN_LARGE_THROW =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GRAN_LARGE_THROW, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> GRAN_EXPLOSIVE_THROW =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GRAN_EXPLOSIVE_THROW, TextureAtlas.class);

    private AssetDescriptors() {
    }
}
