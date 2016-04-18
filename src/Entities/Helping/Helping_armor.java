package Entities.Helping;

import Entities.Entity;
import Graphics.Assets;
import Utilities.Utilities;

import java.awt.*;

public class Helping_armor extends Entity {

    protected float speed = Utilities.getRandom(1,5);

    public Helping_armor(float x, float y) {
        super(x, y);
        speed = 2;
    }

    /**
     * Ticks the current power-up object
     */
    @Override
    public void tick() {
        y += speed;
    }

    /**
     * Renders the current power-up to the screen
     * @param graphics -> Required
     */
    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.armor, (int) x, (int) y, null);
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
