package com.qoire.the_walk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.qoire.the_walk.the_walk;
import com.qoire.the_walk.utils.Constants;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


/**
 * Created by MSI\ysun on 6/16/14.
 */
public class SplashScreen extends AbstractScreen {

    public SplashScreen(the_walk game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        //load necessary
        Drawable splashDrawable = new TextureRegionDrawable(new TextureRegion(new Texture("images/img/rhymusplash.png")));
        //Drawable pokemonDrawable = new TextureRegionDrawable(new TextureRegion(new Texture("images/img/pokemon.png")));

        Music bgm = Gdx.audio.newMusic(Gdx.files.internal("sound/bgm/deadmau5_i_forget.mp3"));


        Image splashImage = new Image(splashDrawable, Scaling.none);
        //Image pokemonImage = new Image(pokemonDrawable, Scaling.none);

        //set index
        splashImage.setZIndex(0);
        //pokemonImage.setZIndex(1);

        //set position
        //pokemonImage.setPosition(Constants.SCREEN_WIDTH/2 - pokemonImage.getWidth()/2,
        //                         Constants.SCREEN_HEIGHT/2 - pokemonImage.getHeight()/2);

        //Gdx.app.log( the_walk.LOG, "Pokemon: " + pokemonImage.getWidth());



        //define actions
        splashImage.setFillParent(true);
        splashImage.getColor().a = 0f;
        splashImage.addAction(sequence(fadeIn(0.75f),
                delay(2.25f),
                fadeOut(0.75f),
                new Action() {
                    @Override
                    public boolean act(float delta) {
                        //get new screen
                        return true;
                    }
                }
                ));

        stage.addActor(splashImage);
        //stage.addActor(pokemonImage);

        //play bgm
        bgm.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
