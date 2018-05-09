package com.cydercode.effects;

import com.cydercode.AbstractObject;
import com.cydercode.Renderable;
import com.cydercode.Updatable;
import com.cydercode.Vector2F;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class FlyingLines extends AbstractObject implements Renderable, Updatable {

    private List<Vector2F> lines = new ArrayList<>();

    private Random random = new Random();

    public FlyingLines(PApplet pApplet) {
        super(pApplet);
        IntStream.range(0, 100).forEach(i -> {
            lines.add(new Vector2F(0, i * 10));
        });
    }

    @Override
    public void render() {
        pApplet.stroke(100, 100, 100);
        lines.forEach(line -> {
            pApplet.line(line.getX(), line.getY(), line.getX() + 100, line.getY());
        });
    }

    @Override
    public void update() {
        lines.forEach(line -> {
            line.setX(line.getX() + random.nextFloat() * 200);
            if (line.getX() > pApplet.width) {
                line.setX(0);
            }
        });
    }
}
