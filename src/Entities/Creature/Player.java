package Entities.Creature;

import java.awt.*;

import Display.Display;
import Entities.Entity;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;

public class Player extends Entity {

    private Engine engine;

    // Properties of the player
    protected int health;
    protected float speed;
    protected boolean aura;
    protected int armor;

    /**
     * Constructor
     * @param engine -> we need it for the keyManager
     * @param x -> position on X axis
     * @param y -> position on Y axis
     */
    public Player(Engine engine, float x, float y) {
        super(x, y);
        this.engine = engine;

        health = 100;
        speed = 10F;
        aura = false;
        armor = 0;
    }

    @Override
    public void tick() {
        if (KeyManager.left) {
            if (x > -10){
                x -= speed;
            }

        }
        if (KeyManager.right) {
            if (x < Display.WINDOW_WIDTH - 52){
                x += speed;
            }

        }
    }

    @Override
    public void render(Graphics graphics) {
        //Just use an existing Asset to image the player. When we decide, will change the image.
        graphics.drawImage(Assets.health, (int) x, (int) y, null);
    }
}
