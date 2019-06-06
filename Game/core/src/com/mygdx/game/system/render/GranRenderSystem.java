package com.mygdx.game.system.render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.assets.AssetDescriptors;
import com.mygdx.game.common.Constants;
import com.mygdx.game.common.Mappers;
import com.mygdx.game.common.enums.PotType;
import com.mygdx.game.component.DimensionComponent;
import com.mygdx.game.component.PositionComponent;
import com.mygdx.game.component.marking.GranComponent;

public class GranRenderSystem extends IteratingSystem {

    private static final Family GRAN = Family.all(
            GranComponent.class,
            PositionComponent.class,
            DimensionComponent.class
    ).get();
    private SpriteBatch batch;
    private Viewport viewport;

    private Texture granStatic;
    private Animation<TextureRegion> simple;
    private Animation<TextureRegion> large;
    private Animation<TextureRegion> explosive;
    private Animation<TextureRegion> iron;

    public GranRenderSystem(SpriteBatch batch, Viewport viewport, AssetManager assetManager) {
        super(GRAN);
        this.batch = batch;
        this.viewport = viewport;
        granStatic = assetManager.get(AssetDescriptors.GRAN_STATIC);
        simple = new Animation<TextureRegion>(Constants.GRAN_FRAME_TIME, assetManager.get(AssetDescriptors.GRAN_SIMPLE_THROW).getRegions());
        iron = new Animation<TextureRegion>(Constants.GRAN_FRAME_TIME, assetManager.get(AssetDescriptors.GRAN_IRON_THROW).getRegions());
        large = new Animation<TextureRegion>(Constants.GRAN_FRAME_TIME, assetManager.get(AssetDescriptors.GRAN_LARGE_THROW).getRegions());
        explosive = new Animation<TextureRegion>(Constants.GRAN_FRAME_TIME, assetManager.get(AssetDescriptors.GRAN_EXPLOSIVE_THROW).getRegions());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        GranComponent gran = Mappers.GRAN.get(entity);
        PositionComponent position = Mappers.POSITION.get(entity);
        DimensionComponent dimension = Mappers.DIMENSION.get(entity);

        if (!gran.isAnimating) {
            drawStatic(position, dimension);
        } else {
            gran.elapsedTime += deltaTime;

            if (gran.animatesType == PotType.SIMPLE) {
                draw(gran, position, dimension, simple);
            } else if (gran.animatesType == PotType.IRON) {
                draw(gran, position, dimension, iron);
            } else if (gran.animatesType == PotType.LARGE) {
                draw(gran, position, dimension, large);
            } else if (gran.animatesType == PotType.EXPLOSIVE) {
                draw(gran, position, dimension, explosive);
            }

        }
    }

    private void drawStatic(PositionComponent position, DimensionComponent dimension) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        batch.draw(
                granStatic,
                position.x - dimension.width / 2f, position.y,
                dimension.width, dimension.height
        );

        batch.end();
    }

    private void draw(GranComponent gran, PositionComponent position, DimensionComponent dimension, Animation<TextureRegion> animation) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        batch.draw(
                animation.getKeyFrame(gran.elapsedTime, false),
                position.x - dimension.width / 2f, position.y,
                dimension.width, dimension.height
        );

        batch.end();

        if (animation.isAnimationFinished(gran.elapsedTime)) {
            gran.isAnimating = false;
        }
    }

    public void throwPot(PotType type) {
        ImmutableArray<Entity> gran = getEngine().getEntitiesFor(GRAN);
        for (Entity entity : gran) {
            GranComponent granComponent = Mappers.GRAN.get(entity);
            granComponent.isAnimating = true;
            granComponent.animatesType = type;
            granComponent.elapsedTime = 0;
        }
    }
}
