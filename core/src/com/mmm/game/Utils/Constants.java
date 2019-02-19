package com.mmm.game.Utils;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int WORLD_WIDTH = 128;
    public static final int WORLD_HEIGHT = 128;

    //Assets
    public static final String ATLAS_IMAGE = "core/assets/images.txt";
    public static final String IMG_HEAD = "head";
    public static final String IMG_BODY = "body";
    public static final String IMG_FOOD = "food";
    public static final String IMG_WALL = "wall";

    //SnakeObject
    public static final int LENGTH_DEFAULT = 4;
    public static final int BODY_SIZE = 32;
    public static final Vector2 START_POSITION = new Vector2(Constants.BODY_SIZE * 5, Constants.BODY_SIZE * 5);

}
