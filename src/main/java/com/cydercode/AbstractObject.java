package com.cydercode;

import processing.core.PApplet;

public abstract class AbstractObject {

    protected final PApplet pApplet;

    public AbstractObject(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public abstract void render();
}
