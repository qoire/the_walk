package com.qoire.the_walk;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.qoire.the_walk.screens.SplashScreen;

public class the_walk extends Game {

    private FPSLogger fpsLogger;
    public static final String LOG = the_walk.class.getSimpleName();

    public the_walk() {}

    public SplashScreen getSplashScreen() {
        return new SplashScreen( this );
    }

    @Override
    public void create() {
        Gdx.app.log(the_walk.LOG, "Creating game");
        fpsLogger = new FPSLogger();
        setScreen(getSplashScreen());
    }

    @Override
    public void render() {
        super.render();
        //FPS
        fpsLogger.log();
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
        Gdx.app.log(the_walk.LOG, "Setting screen: " + screen.getClass().getSimpleName());
    }

    @Override
    public void dispose() {
        super.dispose();
        Gdx.app.log(the_walk.LOG, "Disposing game");
    }



}
