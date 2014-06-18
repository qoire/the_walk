package com.qoire.the_walk.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by MSI\ysun on 6/18/14.
 */
public class BallImage extends Image {

    private Body body;
    private BodyDef bodyDef;
    private CircleShape circle;
    World world;

    public BallImage(Drawable drawable, World world) {
        super(drawable);
        this.world = world;
        initPhysics();
        //implements an object
    }

    @Override
    public void act(float delta) {
        positionCenter(body.getPosition().x, body.getPosition().y);
    }

    private void positionCenter(float x, float y) {
        setPosition(x - getImageWidth()/2, y - getImageWidth()/2);
    }

    private void initPhysics() {
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(100,300);

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

    public void dispose() {
        circle.dispose();
    }
}
