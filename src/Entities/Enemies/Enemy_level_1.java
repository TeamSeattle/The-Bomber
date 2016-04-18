package Entities.Enemies;

import Entities.Entity;
import Graphics.Assets;
import Utilities.Utilities;

import java.awt.*;

public class Enemy_level_1 extends Entity {

    private float speed = Utilities.getRandom(1,5);

    /**
     * Constructor
     * @param x -> X Position
     * @param y -> Y Position
     */
    public Enemy_level_1(float x, float y) {
        super(x, y);
    }

    /**
     * Ticks the current enemy object
     */
    @Override
    public void tick() {
        this.y += speed;
    }

    /**
     * Renders the enemy to the screen
     * @param graphics -> Required
     */
    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.enemy, (int) x, (int) y, null);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
