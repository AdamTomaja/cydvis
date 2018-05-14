package com.cydercode.rectsandlines;

import com.cydercode.Scene;
import processing.core.PApplet;

public class NattiScene extends Scene {

    private long lastTime = System.currentTimeMillis();
    private int elements = 4;
    private int elementsVec = 1;

    public NattiScene(PApplet pApplet) {
        super(pApplet);
    }

    @Override
    public void render() {
        super.render();

        pApplet.stroke(255);

        float segment = 20;
        float distance = 4;
        int count = 0;
        for (int line = 0; line < elements; line++) {
            for (int col = 0; col < elements; col++) {
                count++;
                float x = col * (segment + distance);
                float y = line * (segment + distance);

                if (line % 2 == 0) {
                    // lines
                    if (count % 2 == 0) {
                        pApplet.line(x, y, x + segment, y + segment);
                        pApplet.line(x, y + segment, x + segment, y);
                    }
                } else {
                    // rects
                    if ((count + 1) % 2 == 0) {
                        pApplet.fill(0);
                        pApplet.rect(x, y, segment, segment);
                        pApplet.fill(255);
                        pApplet.triangle(x, y, x + segment, y, x + segment, y + segment);
                    }
                }
            }
        }
    }

    @Override
    public void update() {
        super.update();

        long currentTime = System.currentTimeMillis();
        if(currentTime - lastTime > 50) {
            lastTime = currentTime;
            elements += elementsVec;

            if(elements > 20) {
                elementsVec = -elementsVec;
            }

            if(elements < 3) {
                elementsVec = -elementsVec;
            }
        }
    }
}
