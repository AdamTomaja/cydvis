package com.cydercode.particles;

import com.cydercode.Scene;
import com.cydercode.Timer;
import com.cydercode.Vector2F;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class GravityParticlesScene extends Scene {

    private float gravity = 1.5f;

    private List<Vector2F> particles = new ArrayList<>();

    Timer timer = new Timer(pApplet, 10, () -> {
        System.out.println("Count: " + particles.size());
        particles.add(new Vector2F((float) (Math.random() * pApplet.getWidth() / 2), 0));
    });

    public GravityParticlesScene(PApplet pApplet) {
        super(pApplet);

        addObject(timer);
    }

    @Override
    public void update() {
        super.update();
        particles.forEach(particle -> {
            particle.setY((float) (particle.getY() + gravity * Math.random()));
            if(particle.getY() > pApplet.getHeight()) {
                particle.setY(0);
            }
        });

        if(particles.size() > 5000) {
            timer.remove();
        }
    }

    @Override
    public void render() {
        super.render();

        pApplet.stroke(255, 255, 255);

        particles.forEach(particle -> {
            pApplet.set((int) particle.getX(), (int) particle.getY(), 255);
        });
    }
}
