package com.mmm.game.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch, float delta);
}
