package Entities.Helping;

import Entities.Entity;
import Graphics.Assets;

import java.awt.*;
import java.util.Random;

public class Helping_armor extends Entity {

    Random random = new Random();
    protected float speed = random.nextInt(1) + 2;

    public Helping_armor(float x, float y) {
        super(x, y);
        speed = 2;
    }

    @Override
    public void tick() {
        y += speed;
    }

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
