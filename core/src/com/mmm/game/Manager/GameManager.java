package com.mmm.game.Manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mmm.game.Model.SnakeObject;
import com.mmm.game.Utils.Constants;

public class GameManager {

    private SnakeObject snake;

    public GameManager() {
        snake = new SnakeObject(Constants.START_POSITION);
    }

    public void update(float delta) {
        snake.update(delta);
    }

    public void render(SpriteBatch batch, float delta) {
        snake.render(batch, delta);
    }
}
