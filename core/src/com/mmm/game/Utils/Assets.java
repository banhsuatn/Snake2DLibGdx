package com.mmm.game.Utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable,AssetErrorListener {
    public static final Assets instance = new Assets();

    private AssetManager manager;
    public SnakeImage snakeImage;
    public WallImage wallImage;
    public FoodImage foodImage;

    private Assets(){
        manager = new AssetManager();
        manager.setErrorListener(this);
        manager.load(Constants.ATLAS_IMAGE,TextureAtlas.class);
        manager.finishLoading();

        snakeImage = new SnakeImage(manager.get(Constants.ATLAS_IMAGE, TextureAtlas.class));
        wallImage = new WallImage(manager.get(Constants.ATLAS_IMAGE,TextureAtlas.class));
        foodImage = new FoodImage(manager.get(Constants.ATLAS_IMAGE,TextureAtlas.class));
    }

    public AssetManager getManager() {
        return manager;
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        System.out.println(asset.toString());
    }

    @Override
    public void dispose() {
        manager.dispose();
    }

    public class SnakeImage{
        public final TextureAtlas.AtlasRegion head;
        public final TextureAtlas.AtlasRegion body;

        public SnakeImage(TextureAtlas atlas) {
            head = atlas.findRegion(Constants.IMG_HEAD);
            body = atlas.findRegion(Constants.IMG_BODY);
        }
    }

    public class WallImage{
        public final TextureAtlas.AtlasRegion wall;

        public WallImage(TextureAtlas atlas) {
            this.wall = atlas.findRegion(Constants.IMG_WALL);
        }
    }

    public class FoodImage{
        public final TextureAtlas.AtlasRegion food;

        public FoodImage(TextureAtlas atlas) {
            this.food = atlas.findRegion(Constants.IMG_FOOD);
        }
    }
}
