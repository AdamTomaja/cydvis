package com.cydercode.balls;

import com.cydercode.Scene;
import com.cydercode.Vector2F;
import com.cydercode.VisibleObject;
import com.cydercode.color.Color;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallsScene extends Scene {

    private Random random = new Random();

    public BallsScene(PApplet pApplet) {
        super(pApplet);
        addObject(new BallMovingSpawner(this, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2), new Color(100, 100, 100)));
        addObject(new BallMovingSpawner(this, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2), new Color(100, 0, 0)));
    }

    @Override
    public void update() {
        super.update();

        List<VisibleObject> copy = new ArrayList<>();
        copy.addAll(objects);

        if(objects.size() == 0) {
            addObject(new BallMovingSpawner(this, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2), new Color(random.nextInt(255), 100, 100)));
            addObject(new BallMovingSpawner(this, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2), new Color(random.nextInt(255), 100, 100)));
        }
    }
}
