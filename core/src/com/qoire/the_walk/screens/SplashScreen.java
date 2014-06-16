package com.qoire.the_walk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.qoire.the_walk.the_walk;

/**
 * Created by MSI\ysun on 6/16/14.
 */
public class SplashScreen extends AbstractScreen {
    private Texture splashTexture;

    public SplashScreen(the_walk game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        splashTexture = new Texture("badlogic.jpg");

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(splashTexture, 0, 0);

        //end
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        splashTexture.dispose();
    }
}
