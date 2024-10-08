package com.mynta.gametowerdefense.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mynta.gametowerdefense.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL30 = false;
		config.height = 500;
		config.width = 1000;
		new LwjglApplication(new MyGame(), config);
	}
}
