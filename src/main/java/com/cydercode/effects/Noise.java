package com.cydercode.effects;

import com.cydercode.AbstractObject;
import com.cydercode.Renderable;
import com.cydercode.color.Color;
import com.cydercode.color.ColorPallete;
import processing.core.PApplet;

import java.util.Random;

public class Noise extends AbstractObject implements Renderable {

    private Random random = new Random();
    private ColorPallete colorPallete = new ColorPallete();

    public Noise(PApplet pApplet) {
        super(pApplet);
    }

    @Override
    public void render() {
        for (int x = 0; x < pApplet.width; x += 20) {
            for (int y = 0; y < pApplet.height; y += 20) {
                if (random.nextFloat() > 0.7) {
                    Color color = colorPallete.getRandomColor();
                    float vec = random.nextFloat() * 10;
                    pApplet.stroke(color.getR(), color.getG(), color.getB());
                    pApplet.line(x, y, x - vec, y - vec);
                }
            }
        }
    }
}