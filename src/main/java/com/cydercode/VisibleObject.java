package com.cydercode;

import processing.core.PApplet;

public abstract class VisibleObject extends AbstractObject implements Renderable {

    protected Vector2F position;

    public VisibleObject(PApplet pApplet, Vector2F position) {
        super(pApplet);
        this.position = position;
    }
}
