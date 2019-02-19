package com.mmm.game.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mmm.game.Manager.GameManager;
import com.mmm.game.Utils.Constants;


public class MainGameView extends ScreenAdapter {

    private SpriteBatch batch;
    private Viewport viewport;
    private GameManager gameManager;

    @Override
    public void show() {
        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        batch = new SpriteBatch();

        gameManager = new GameManager();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        gameManager.update(delta);

        Gdx.gl.glClearColor(Color.SKY.r, Color.SKY.g, Color.SKY.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        batch.begin();
        gameManager.render(batch,delta);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

