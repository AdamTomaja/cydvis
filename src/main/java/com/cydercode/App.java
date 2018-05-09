package com.cydercode;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class App extends PApplet {

    private final int WIDTH = 800, HEIGHT = 600;

    private List<VisibleObject> objects = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void setup() {
        size(WIDTH, HEIGHT);

        IntStream.range(0, 30)
                .forEach(i -> objects.add(new Ball(this, new Vector2F(random.nextInt(WIDTH), random.nextInt(HEIGHT)))));
    }

    @Override
    public void draw() {
        background(255, 204, 0);
        objects.forEach(obj -> {
            if (obj instanceof Updatable) {
                ((Updatable) obj).update();
            }
        });
        objects.forEach(obj -> obj.render());
    }

    public static void main(String[] args) {
        PApplet.main(App.class.getName());
    }
}
