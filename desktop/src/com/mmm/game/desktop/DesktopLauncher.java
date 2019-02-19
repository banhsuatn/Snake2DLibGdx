package com.mmm.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mmm.game.Snake2DGame;
import com.mmm.game.Utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.WORLD_WIDTH * 6;
		config.height = Constants.WORLD_HEIGHT * 6;
		new LwjglApplication(new Snake2DGame(), config);
	}
}
