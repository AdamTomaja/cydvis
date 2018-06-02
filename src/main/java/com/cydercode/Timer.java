package com.cydercode;

import processing.core.PApplet;

public class Timer extends AbstractObject implements Updatable {

    private final Runnable task;
    private final long millisPeriod;

    private long lastExecuted = System.currentTimeMillis();

    public Timer(PApplet pApplet, long millisPeriod, Runnable task) {
        super(pApplet);
        this.millisPeriod = millisPeriod;
        this.task = task;
    }

    @Override
    public void update() {
        long time = System.currentTimeMillis();
        if (time - lastExecuted > millisPeriod) {
            task.run();
            lastExecuted = time;
        }
    }
}
