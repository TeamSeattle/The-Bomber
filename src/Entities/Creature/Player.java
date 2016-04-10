package Entities.Creature;

import Display.Display;
import Effects.Aura;
import Entities.Entity;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;

import java.awt.*;

public class Player extends Entity {

    private Engine engine;

    // Properties of the player
    protected int health;
    protected float speed;
    protected Aura aura;
    protected int armor;

    /**
     * Constructor
     *
     * @param engine -> we need it for the keyManager
     * @param x      -> position on X axis
     * @param y      -> position on Y axis
     */
    public Player(Engine engine, float x, float y) {
        super(x, y);
        this.engine = engine;

        health = 100;
        speed = 8F;
        aura = new Aura(false);
        armor = 0;
    }

    @Override
    public void tick() {
        if (KeyManager.left) {
            if (x > -25) {
                x -= speed;
            }
        }
        if (KeyManager.right) {
            if (x < Display.WINDOW_WIDTH - 100) {
                x += speed;
            }
        }

        // Temporary to test the aura effect
        if (KeyManager.auraSwitch) {
            aura.setIsActive(true);
        }
        if (aura.getIsActive()) {
            aura.tick();
            System.out.println("Aura tick");
        }
    }

    @Override
    public void render(Graphics graphics) {
        //Just use an existing Asset to image the player. When we decide, will change the image.
        graphics.drawImage(Assets.health, (int) x, (int) y, null);
        if (aura.getIsActive()) {
            aura.render(graphics, (int) x, (int) y);
            System.out.println("Aura tick");
        }
    }
}
