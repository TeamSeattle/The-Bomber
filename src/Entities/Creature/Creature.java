package Entities.Creature;


import Entities.Entity;

public abstract class Creature extends Entity {

    protected int health;
    protected int speed;
    protected int aura;
    protected int armor;

    public Creature(float x, float y) {
        super(x, y);
        health = 100;
        speed = 3;
        aura = 0;
        armor = 100;
    }
}
