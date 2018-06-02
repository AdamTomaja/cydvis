package com.cydercode;

import com.cydercode.balls.BallsScene;
import com.cydercode.particles.ParticlesScene;
import com.cydercode.rectsandlines.NattiScene;
import processing.core.PApplet;

public class App extends PApplet {

    private final int WIDTH = 800, HEIGHT = 600;

    private Scene scene = new ParticlesScene(this);

    @Override
    public void setup() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        scene.update();
        scene.render();
    }

    public static void main(String[] args) {
        PApplet.main(App.class.getName());
    }
}
