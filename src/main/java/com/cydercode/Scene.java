package com.cydercode;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Scene extends AbstractObject implements Updatable, Renderable {

    protected List<AbstractObject> objects = new ArrayList<>();

    public Scene(PApplet pApplet) {
        super(pApplet);
    }

    @Override
    public void render() {
        pApplet.background(0, 0, 0);
        objects.stream()
                .filter(Renderable.class::isInstance)
                .map(Renderable.class::cast)
                .forEach(obj -> obj.render());
    }


    @Override
    public void update() {
        List<AbstractObject> copy = new ArrayList<>();
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

    public void addObject(AbstractObject object) {
        objects.add(object);
    }

    public int getObjectsCount() {
        return objects.size();
    }
}
