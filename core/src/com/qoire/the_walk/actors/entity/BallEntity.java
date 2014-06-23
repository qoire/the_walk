package com.qoire.the_walk.actors.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Yao on 6/22/2014.
 */
public class BallEntity extends Entity {

    private Body body;
    private BodyDef bodyDef;
    private CircleShape circle;
    private World world;

    /** sprites section **/
    private Image BallImage;

    public BallEntity(World world) {
        this.world = world;
    }

    public void setActor(float x, float y) {
        initBallImage(x,y);
    }

    public void setPhysics(float x, float y) {
        initPhysics(x, y);
    }

    private void initBallImage(float x, float y) {
        Drawable ballDrawable = new TextureRegionDrawable(new TextureRegion(new Texture("images/img/great_ball.png")));
        BallImage = new Image(ballDrawable);
    }

    private void initPhysics(float x, float y) {
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);

        body = world.createBody(bodyDef);
        circle = new CircleShape();
        circle.setRadius(8f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;

        body.createFixture(fixtureDef);

    }

    private void dispose() {

    }
}
