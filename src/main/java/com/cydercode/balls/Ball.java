package com.cydercode.balls;

import com.cydercode.Updatable;
import com.cydercode.Vector2F;
import com.cydercode.VisibleObject;
import com.cydercode.color.Color;
import processing.core.PApplet;

public class Ball extends VisibleObject implements Updatable {

    private Vector2F movVec = new Vector2F((float) (Math.random() - 0.5f) * 10, (float) (Math.random() - 0.5f) * 10);

    private long startTimestamp = System.currentTimeMillis();

    protected Color color;

    public Ball(PApplet pApplet, Vector2F position, Color color) {
        super(pApplet, position);
        this.color = color;
    }

    @Override
    public void render() {
        pApplet.fill(getLife() / 100f * color.getR(), getLife() / 100f * color.getG(), getLife() / 100f * color.getB());
        pApplet.ellipse(position.getX(), position.getY(), getLife(), getLife());
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

        if (getLife() < 0) {
            remove();
        }
    }

    public float getLife() {
        return (10_000 - (System.currentTimeMillis() - startTimestamp)) / 10_000f * 100f;
    }
}
