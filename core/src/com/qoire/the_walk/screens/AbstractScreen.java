package com.qoire.the_walk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.qoire.the_walk.the_walk;

/**
 * Created by MSI\ysun on 6/16/14.
 */
public abstract class AbstractScreen implements Screen {
    protected final the_walk game;
    protected final Stage stage;

    /** non critical functions **/
    private BitmapFont font;
    private SpriteBatch batch;

    public AbstractScreen(the_walk game) {
        this.game = game;
        this.stage = new Stage();

    }

    protected String getName() {
        return getClass().getSimpleName();
    }

    //screen implementation
    @Override
    public void show() {
        Gdx.app.log( the_walk.LOG, "Showing screen: " + getName() );
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        stage.act( delta );
        stage.draw();
    }

    @Override
    public void hide()
    {
        Gdx.app.log( the_walk.LOG, "Hiding screen: " + getName() );
    }

    @Override
    public void pause()
    {
        Gdx.app.log( the_walk.LOG, "Pausing screen: " + getName() );
    }

    @Override
    public void resume()
    {
        Gdx.app.log( the_walk.LOG, "Resuming screen: " + getName() );
    }

    @Override
    public void dispose()
    {
        Gdx.app.log( the_walk.LOG, "Disposing screen: " + getName() );

        // dispose the collaborators
        stage.dispose();
        batch.dispose();
    }

    /** lazy loading **/
    public BitmapFont getFont() {
        if (font == null) {
            font = new BitmapFont();
        }
        return font;
    }

    public SpriteBatch getBatch() {
        if (batch == null) {
            batch = new SpriteBatch();
        }
        return batch;
    }

}
