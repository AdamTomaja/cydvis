package com.cydercode;

import processing.core.PApplet;

public class Ball extends VisibleObject implements Updatable {

    private Vector2F movVec = new Vector2F((float) (Math.random() - 0.5f) * 10, (float) (Math.random() - 0.5f) * 10);

    public Ball(PApplet pApplet, Vector2F position) {
        super(pApplet, position);
    }

    @Override
    public void render() {
        pApplet.fill(255, 0, 0);
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
}
