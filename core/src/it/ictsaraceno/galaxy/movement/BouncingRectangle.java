package it.ictsaraceno.galaxy.movement;

import com.badlogic.gdx.math.Rectangle;

public class BouncingRectangle extends Rectangle {

    private static final int SPEED = 200;
    private final int SCREEN_WIDTH;
    private final int SCREEN_HEIGHT;

    private int directionX = 1;
    private int directionY = 1;

    public BouncingRectangle(int screenWidth, int screenHeight) {
        SCREEN_WIDTH = screenWidth;
        SCREEN_HEIGHT = screenHeight;
    }

    public void update(float delta) {
        x += SPEED * delta * directionX;
        y += SPEED * delta * directionY;

        if (x < 0) {
            x = 0;
            directionX = 1;
        }
        if (x > SCREEN_WIDTH - width) {
            x = SCREEN_WIDTH - width;
            directionX = -1;
        }
        if (y < 0) {
            y = 0;
            directionY = 1;
        }
        if (y > SCREEN_HEIGHT - height) {
            y = SCREEN_HEIGHT - height;
            directionY = -1;
        }
    }

}
