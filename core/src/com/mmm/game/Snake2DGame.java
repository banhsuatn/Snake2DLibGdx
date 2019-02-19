package com.mmm.game;

import com.badlogic.gdx.Game;
import com.mmm.game.View.MainGameView;

public class Snake2DGame extends Game {
	
	@Override
	public void create () {
        setScreen(new MainGameView());
	}
}
