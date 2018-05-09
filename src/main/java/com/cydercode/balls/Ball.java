package com.cydercode.balls;

import com.cydercode.Updatable;
import com.cydercode.Vector2F;
import com.cydercode.VisibleObject;
import processing.core.PApplet;

public class Ball extends VisibleObject implements Updatable {

    private Vector2F movVec = new Vector2F((float) (Math.random() - 0.5f) * 10, (float) (Math.random() - 0.5f) * 10);

    private long startTimestamp = System.currentTimeMillis();

    public Ball(PApplet pApplet, Vector2F position) {
        super(pApplet, position);
    }

    @Override
    public void render() {
        float v1 = getLife() / 100f * 255;
        pApplet.fill(v1, v1, v1);
        pApplet.ellipse(position.getX(), position.getY(), 20, 20);
    }

    @Override
    public void update() {
        position.add(movVec);
        if (position.getX() < 0 || position.getX() >= pApplet.width) {
            movVec.invertX();
        }

        if (position.getY() < 0 || position.getY() >= pApplet.height) {
            movVec.invertY();
        }
    }

    public float getLife() {
        return (10_000 - (System.currentTimeMillis() - startTimestamp)) / 10_000f * 100f;
    }
}
