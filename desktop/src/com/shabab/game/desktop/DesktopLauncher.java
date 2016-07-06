package com.shabab.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shabab.game.MyFlappySuperman;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MyFlappySuperman.WIDTH;
		config.height = MyFlappySuperman.HEIGHT;
		config.title = MyFlappySuperman.TITLE;

		new LwjglApplication(new MyFlappySuperman(), config);
	}
}
