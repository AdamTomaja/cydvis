package com.cydercode.particles;

import com.cydercode.Scene;
import com.cydercode.Vector2F;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticlesScene extends Scene {

    private final List<Vector2F> particles = new ArrayList<>();

    private final Vector2F target = new Vector2F(300, 300);
    private final Vector2F targetVec = new Vector2F(3, 3);

    private final Random random = new Random();

    private long lastAdded = System.currentTimeMillis();
    private long lastHaos = System.currentTimeMillis();
    private long lastHaosStop = System.currentTimeMillis();

    public ParticlesScene(PApplet pApplet) {
        super(pApplet);
    }

    @Override
    public void render() {
        super.render();
        pApplet.stroke(100, 100, 100);
    }

    @Override
    public void update() {
        super.update();

        long time = System.currentTimeMillis();
        if (time - lastAdded > 10 && objects.size() < 500) {
            addObject(new Particle(pApplet,
                    new Vector2F(300, 300),
                    target));
            lastAdded = time;
        }


        if (time - lastHaos > 5000) {
            objects.forEach(particle -> {
                if (particle instanceof Particle) {
                    ((Particle) particle).setMovementVector(new Vector2F(random.nextFloat() * 6 - 3, random.nextFloat() * 6 - 3));
                }
            });

            lastHaos = time;
        }

        if (time - lastHaosStop > 5500) {
            objects.forEach(particle -> {
                if (particle instanceof Particle) {
                    ((Particle) particle).setMovementVector(new Vector2F(0, 0));
                }
            });
            lastHaosStop = time;
        }

        target.add(targetVec);

        if (target.getY() > pApplet.getHeight()) {
            targetVec.setY(-random.nextFloat());
        }

        if (target.getY() <= 0) {
            targetVec.setY(random.nextFloat());
        }

        if (target.getX() > pApplet.getWidth()) {
            targetVec.setX(-random.nextFloat());
        }

        if (target.getX() <= 0) {
            targetVec.setX(random.nextFloat());
        }
    }
}
