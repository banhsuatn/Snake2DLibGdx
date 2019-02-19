package com.mmm.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mmm.game.Utils.Assets;
import com.mmm.game.Utils.Constants;
import com.mmm.game.Utils.Utils;

import java.util.ArrayList;

public class SnakeObject extends GameObject {

    private ArrayList<Vector2> body;
    private Direction direction;
    private int speed = 10;
    private int s = 0;


    public SnakeObject(Vector2 positionHead) {
        body = new ArrayList<Vector2>();
        body.add(positionHead);
        for (int i = 1; i < Constants.LENGTH_DEFAULT; i++) {
            body.add(new Vector2(body.get(0).x - i * Constants.BODY_SIZE, body.get(0).y));
        }
        direction = Direction.RIGHT;
    }

    @Override
    public void update(float delta) {
        s++;
        if (s != 60 / speed) {
            return;
        }
        s = 0;
        body.add(1, body.get(0).cpy());
        body.remove(body.size() - 1);
        switch (direction) {
            case LEFT:
                body.get(0).add(-Constants.BODY_SIZE, 0);
                break;
            case UP:
                body.get(0).add(0, Constants.BODY_SIZE);
                break;
            case RIGHT:
                body.get(0).add(Constants.BODY_SIZE, 0);
                break;
            case DOWN:
                body.get(0).add(0, -Constants.BODY_SIZE);
                break;
            default:
                break;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && direction != Direction.RIGHT) {
            direction = Direction.LEFT;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && direction != Direction.LEFT) {
            direction = Direction.RIGHT;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && direction != Direction.DOWN) {
            direction = Direction.UP;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && direction != Direction.UP) {
            direction = Direction.DOWN;
        }
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        for (int i = 0; i < body.size(); i++) {
            if (i == 0) {
                Utils.drawTexture(batch, Assets.instance.snakeImage.head,
                        body.get(i).x, body.get(i).y);
            } else {
                Utils.drawTexture(batch, Assets.instance.snakeImage.body,
                        body.get(i).x, body.get(i).y);
            }
        }
    }

    enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }
}