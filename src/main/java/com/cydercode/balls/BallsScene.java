package com.cydercode.balls;

import com.cydercode.Scene;
import com.cydercode.Vector2F;
import com.cydercode.VisibleObject;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class BallsScene extends Scene {

    public BallsScene(PApplet pApplet) {
        super(pApplet);
        addObject(new BallMovingSpawner(this, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2)));
    }

    @Override
    public void update() {
        super.update();

        List<VisibleObject> copy = new ArrayList<>();
        copy.addAll(objects);

        copy.forEach(obj -> {
            if (obj instanceof Ball) {
                if (((Ball) obj).getLife() < 0) {
                    objects.remove(obj);
                }
            }
        });
    }
}
