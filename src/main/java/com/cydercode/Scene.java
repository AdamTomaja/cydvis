package com.cydercode;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Scene extends AbstractObject implements Updatable {

    protected List<VisibleObject> objects = new ArrayList<>();

    public Scene(PApplet pApplet) {
        super(pApplet);
    }

    @Override
    public void render() {
        pApplet.background(0, 0, 0);
        objects.forEach(obj -> obj.render());

        pApplet.textSize(15);
        renderUI();
    }

    private void renderUI() {
        pApplet.fill(150, 150, 150);
        pApplet.text("Objects: " + objects.size(), 10, 30);
    }

    @Override
    public void update() {
        List<VisibleObject> copy = new ArrayList<>();
        copy.addAll(objects);

        copy.forEach(obj -> {
            if (obj instanceof Updatable) {
                ((Updatable) obj).update();
            }
        });
    }

    public void addObject(VisibleObject object) {
        objects.add(object);
    }
}
