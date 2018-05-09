package com.cydercode.balls;

import com.cydercode.Scene;
import com.cydercode.Vector2F;
import com.cydercode.color.ColorPallete;
import com.cydercode.effects.BlinkingText;
import com.cydercode.effects.FlyingLines;
import com.cydercode.effects.Noise;
import processing.core.PApplet;
import processing.core.PImage;

public class BallsScene extends Scene {

    private ColorPallete colorPallete = new ColorPallete();

    private Scene ballsScene;
    PImage pImage;

    public BallsScene(PApplet pApplet) {
        super(pApplet);

        ballsScene = new Scene(pApplet);
        addObject(ballsScene);


        addObject(new Noise(pApplet));
        addObject(new FlyingLines(pApplet));
        addObject(new BlinkingText(pApplet, "CyderCode", new Vector2F(200, 100)));
    }

    @Override
    public void render() {
        super.render();
        pApplet.fill(150, 150, 150);
        pApplet.textSize(10);
        pApplet.text("Objects: " + objects.size(), 10, 30);
        pApplet.filter(pApplet.BLUR, 1);
    }

    @Override
    public void update() {
        super.update();

        if (ballsScene.getObjectsCount() == 0) {
            ballsScene.addObject(new BallMovingSpawner(ballsScene, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2), colorPallete.getRandomColor()));
            ballsScene.addObject(new BallMovingSpawner(ballsScene, pApplet, new Vector2F(pApplet.width / 2, pApplet.height / 2), colorPallete.getRandomColor()));
        }
    }
}
