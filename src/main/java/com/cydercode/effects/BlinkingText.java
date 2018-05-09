package com.cydercode.effects;

import com.cydercode.AbstractObject;
import com.cydercode.Renderable;
import com.cydercode.Vector2F;
import processing.core.PApplet;

import java.util.Random;

public class BlinkingText extends AbstractObject implements Renderable {

    private Random random = new Random();

    private final Vector2F position;
    private final String text;


    public BlinkingText(PApplet pApplet, String text, Vector2F position) {
        super(pApplet);
        this.position = position;
        this.text = text;
    }

    @Override
    public void render() {
        if (random.nextFloat() > 0.3f) {

            for (int i = 50; i > 0; i -= 10) {
                pApplet.fill(100 - i, 100 - i, 100 - i);
                pApplet.textSize(50 - i + 10);
                pApplet.text(text, position.getX() + i * 3, position.getY() + i * 3);
            }
        }
    }
}
