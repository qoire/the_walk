package com.qoire.the_walk.screens;

import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.qoire.the_walk.the_walk;

/**
 * Created by MSI\ysun on 6/16/14.
 */
public class MenuScreen extends AbstractScreen {

    private static TweenManager tweenManager;

    public MenuScreen(the_walk game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        Drawable menuBackgroundDrawable = new TextureRegionDrawable(new TextureRegion(new Texture("images/img/menu_background.png")));
        Image menuBackgroundImage = new Image(menuBackgroundDrawable);

        stage.addActor(menuBackgroundImage);
    }

}
