package Entities.Helping;

import Graphics.Assets;
import Main.Engine;


import java.awt.*;
import java.util.Random;

public class Helping_Health {
    private Engine engine;
    private float x, y;

    Random random = new Random();
    protected float speed = random.nextInt(1) + 2;

    public Helping_Health(Engine engine, float x, float y) {
        super();
        this.engine = engine;
    }

    public Helping_Health(float x, float y, Engine engine) {
        super();
        this.engine = engine;
    }

    //  @Override
    public void tick() {
        this.y += speed;
    }

    //  @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.healthObject, (int) x, (int) y, null);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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
