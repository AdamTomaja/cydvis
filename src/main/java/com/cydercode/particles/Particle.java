package com.cydercode.particles;

import com.cydercode.Updatable;
import com.cydercode.Vector2F;
import com.cydercode.VisibleObject;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Particle extends VisibleObject implements Updatable {

    private final Vector2F target;

    private float speed = 1f;

    private Vector2F movementVector = new Vector2F(0, 0);

    private List<Vector2F> sparcles = new ArrayList<>();

    Random random = new Random();

    public Particle(PApplet pApplet, Vector2F position, Vector2F target) {
        super(pApplet, position);

        this.target = target;

        for (int i = 0; i < 10; i++) {
            sparcles.add(new Vector2F(random.nextFloat() * 5 - 2.5f, random.nextFloat() * 3 - 1.5f));
        }
    }

    public void setMovementVector(Vector2F movementVector) {
        this.movementVector = movementVector;
        sparcles.forEach(sparcle -> sparcle.set(random.nextFloat() * 2, random.nextFloat() * 2));
    }

    @Override
    public void render() {
        pApplet.stroke(255, 255, 255);
        pApplet.ellipse(position.getX(), position.getY(), 1, 1);

        pApplet.stroke(255, 0, 0);
        sparcles.forEach(sparcle -> {
            if (Math.abs(sparcle.getY()) < 30) {
                pApplet.ellipse(position.getX() + sparcle.getX(), position.getY() + sparcle.getY(), 2, 2);
            }
        });
    }

    @Override
    public void update() {
        position.setX(position.getX() + (position.getX() > target.getX() ? -speed : speed));
        position.setY(position.getY() + (position.getY() > target.getY() ? -speed : speed));

        sparcles.forEach(sparcle -> {
            sparcle.setX(sparcle.getX() * 1.05f);
            sparcle.setY(sparcle.getY() * 1.05f);
        });
        position.add(movementVector);


    }
}
