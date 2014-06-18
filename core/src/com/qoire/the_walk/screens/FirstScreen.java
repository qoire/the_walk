package com.qoire.the_walk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.qoire.the_walk.actors.BallImage;
import com.qoire.the_walk.the_walk;
import com.qoire.the_walk.utils.BodyEditorLoader;

/**
 * Created by MSI\ysun on 6/18/14.
 */
public class FirstScreen extends AbstractScreen {

    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    OrthographicCamera camera = new OrthographicCamera(1280, 720);
    World world = new World(new Vector2(0, -80), true);

    //box2d members
    private PolygonShape groundBox;
    private BallImage ball;
    private Body FloorBody;

    public FirstScreen(the_walk game) {
        super(game);
    }

    @Override
    public void show() {

        //define an image
        Drawable ballDrawable = new TextureRegionDrawable(new TextureRegion(new Texture("images/img/great_ball.png")));

        ball = new BallImage(ballDrawable, world);
        //define ground
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.position.set(new Vector2(0, 0));

        //create ground body
        Body groundBody = world.createBody(groundBodyDef);

        groundBox = new PolygonShape();
        groundBox.setAsBox(camera.viewportWidth, 10.0f);
        groundBody.createFixture(groundBox, 0.0f);

        createFloor();

        //add actors to stage:
        stage.addActor(ball);
        stage.getViewport().setCamera(camera);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        //update
        world.step(1/60f, 6, 2);

        stage.act( delta );
        stage.draw();

        debugRenderer.render(world, camera.combined);
    }

    @Override
    public void dispose() {
        ball.dispose();
        groundBox.dispose();
    }

    private void createFloor() {
        BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("body/floor.body"));

        BodyDef bd = new BodyDef();
        bd.position.set(0, 0);
        bd.type = BodyDef.BodyType.StaticBody;

        FixtureDef fd = new FixtureDef();
        fd.density = 1;
        fd.friction = 0.5f;
        fd.restitution = 0.3f;

        FloorBody = world.createBody(bd);
        loader.attachFixture(FloorBody, "tempbody", fd, stage.getWidth()/3f);
    }
}
