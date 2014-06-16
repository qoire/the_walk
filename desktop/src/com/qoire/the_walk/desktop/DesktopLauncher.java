package com.qoire.the_walk.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.qoire.the_walk.the_walk;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
        config.height = 720;
        config.title = "Walk";
        new LwjglApplication(new the_walk(), config);
	}
}
