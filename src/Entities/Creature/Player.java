package Entities.Creature;

import DIsplay.Display;
import Effects.Effect_Aura;
import Effects.Effect_Speed;
import Entities.Entity;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;

import java.awt.*;

public class Player extends Entity {

    private Engine engine;

    // Properties of the player
    protected int health;
    protected int maxHealth;
    protected float speed;
    protected int armor;

    // Effects
    protected Effect_Aura aura_eff;
    protected Effect_Speed speed_eff;

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

        // Initialize properties
        health = 100;
        speed = 8F;
        armor = 0;

        // Initialize effects
        aura_eff = new Effect_Aura(false);
        speed_eff = new Effect_Speed(false);
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
            aura_eff.setIsActive(true);
        }
        if (aura_eff.getIsActive()) {
            aura_eff.tick();
            System.out.println("Effect_Aura tick");
        }

        // Temporary to test the speed effect
        if (KeyManager.speedSwitch) {
            speed_eff.setIsActive(true);
            speed = 20;
        }
        if (speed_eff.getIsActive()) {
            speed_eff.tick();
            System.out.println("Effect_Speed tick");
        } else speed = 8f;
    }

    @Override
    public void render(Graphics graphics) {
        //Just use an existing Asset to image the player. When we decide, will change the image.
        graphics.drawImage(Assets.player, (int) x, (int) y, null);

        // Aura
        if (aura_eff.getIsActive()) {
            aura_eff.render(graphics, (int) x, (int) y);
        }

        // Speed
        if (speed_eff.getIsActive()) {
            speed_eff.render(graphics, (int) x, (int) y);
        }
    }
}
