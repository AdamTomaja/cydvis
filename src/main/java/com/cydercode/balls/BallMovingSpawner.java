package com.cydercode.balls;

import com.cydercode.Scene;
import com.cydercode.Vector2F;
import processing.core.PApplet;

public class BallMovingSpawner extends Ball {

    private final Scene scene;

    long lastBallAddedTImestamp = System.currentTimeMillis();
    int balls = 0;

    public BallMovingSpawner(Scene scene, PApplet pApplet, Vector2F position) {
        super(pApplet, position);
        this.scene = scene;
    }

    @Override
    public void update() {
        super.update();

        if (System.currentTimeMillis() - lastBallAddedTImestamp > 300 && balls < 1000) {
            scene.addObject(new Ball(pApplet, new Vector2F(position.getX(), position.getY())));
            balls++;
        }
    }
}
