package com.cydercode;

import processing.core.PApplet;

public abstract class AbstractObject implements Removable {

    protected final PApplet pApplet;
    private boolean shouldBeRemoved;

    public AbstractObject(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    @Override
    public void remove() {
        shouldBeRemoved = true;
    }

    @Override
    public boolean isShouldBeRemoved() {
        return shouldBeRemoved;
    }
}
