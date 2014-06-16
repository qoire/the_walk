package com.qoire.the_walk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.qoire.the_walk.the_walk;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


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
        Drawable splashDrawable = new TextureRegionDrawable(new TextureRegion(new Texture("badlogic.jpg")));
        Image splashImage = new Image(splashDrawable, Scaling.stretch);
        splashImage.setFillParent(true);

        splashImage.getColor().a = 0f;

        splashImage.addAction(sequence(fadeIn(0.75f), delay(2.25f), fadeOut(0.75f),
                new Action() {
                    @Override
                    public boolean act(float delta) {
                        //get new screen
                        return true;
                    }
                }
                ));
        stage.addActor(splashImage);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        splashTexture.dispose();
    }
}
