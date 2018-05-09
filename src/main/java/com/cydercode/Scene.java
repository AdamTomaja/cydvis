package com.cydercode;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene extends AbstractObject implements Updatable, Renderable {

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

            if (obj.isShouldBeRemoved()) {
                objects.remove(obj);
            }
        });
    }

    public void addObject(VisibleObject object) {
        objects.add(object);
    }
}
