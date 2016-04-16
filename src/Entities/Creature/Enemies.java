package Entities.Creature;

import Entities.Entity;
import Graphics.Assets;
import Main.Engine;

import java.awt.*;
import java.util.Random;

public class Enemies extends Entity {
    private Engine engine;
    private float x, y;


    Random random = new Random();
    protected float speed = random.nextInt(5) + 1;


    public Enemies(Engine engine, float x, float y) {
        super(x, y);
        this.engine = engine;
    }

    public Enemies(float x, float y, Engine engine) {
        super(x, y);
        this.engine = engine;
    }



    @Override
    public void tick() {

        this.y += speed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.enemy, (int) x, (int) y, null);

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
