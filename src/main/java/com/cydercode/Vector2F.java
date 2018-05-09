package com.cydercode;

public class Vector2F {

    private float x;
    private float y;

    public Vector2F(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void invertX() {
        x *= -1;
    }

    public void invertY() {
        y *= -1;
    }

    public void add(Vector2F vector2F) {
        x += vector2F.x;
        y += vector2F.y;
    }
}
