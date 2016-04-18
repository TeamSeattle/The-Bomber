package Entities.Helping;

import Graphics.Assets;

import java.awt.*;
import java.util.Random;

public class Helping_Health {
    private float x;
    private float y;

    Random random = new Random();
    protected float speed = random.nextInt(1) + 2;

    public Helping_Health(float x, float y) {
        super();
    }

    //  @Override
    public void tick() {
        this.y += speed;
    }

    //  @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.health, (int) x, (int) y, null);
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
