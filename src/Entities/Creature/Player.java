package Entities.Creature;

import DIsplay.Display;
import Effects.Effect_Aura;
import Effects.Effect_Speed;
import Entities.Entity;
import Graphics.Assets;
import Graphics.Animation;
import Input.KeyManager;
import Main.Engine;
import States.StateManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    // Properties of the player
    public int HEALTH;
    public int MAX_HEALTH;
    private float SPEED;
    public int ARMOUR;
    public int MAX_ARMOUR;

    // Points
    public static int POINTS;

    // Animations
    private Animation player_walk_right;
    private Animation player_walk_left;

    // Effects
    public Effect_Aura aura_eff;
    public Effect_Speed speed_eff;

    // IMAGE
    private static BufferedImage player_stand = Assets.player_stand;
    public boolean isDead;

    /**
     * Constructor
     *
     * @param x -> position on X axis
     * @param y -> position on Y axis
     */
    public Player(float x, float y) {
        super(x, y, player_stand.getWidth(), player_stand.getHeight());

        // Initialize properties
        HEALTH = 5;
        MAX_HEALTH = 5;
        ARMOUR = 5;
        MAX_ARMOUR = 5;
        SPEED = 8F;

        // Points
        POINTS = 0;

        // Animations
        player_walk_left = new Animation(200, Assets.player_walk_left);
        player_walk_right = new Animation(200, Assets.player_walk_right);

        // Initialize effects
        aura_eff = new Effect_Aura(false);
        speed_eff = new Effect_Speed(false);

        // State
        isDead = false;
    }

    @Override
    public void tick() {
        // Animation
        player_walk_left.tick();
        player_walk_right.tick();

        // Movement
        if (KeyManager.left) {
            if (x > 8) {
                x -= SPEED;
            }
        }
        if (KeyManager.right) {
            if (x < Display.WINDOW_WIDTH - 56) {
                x += SPEED;
            }
        }

        // AURA
        if (KeyManager.auraSwitch) {
            Effect_Aura.setIsActive(true);
        }
        if (Effect_Aura.getIsActive()) {
            aura_eff.tick();
            System.out.println("Effect_Aura tick");
        }


        // SPEED
        if (KeyManager.speedSwitch) {
            Effect_Speed.setIsActive(true);
            SPEED = 20;
        }

        if (speed_eff.getIsActive()) {
            speed_eff.tick();
            SPEED = 20;
            System.out.println("Effect_Speed tick");
        } else {
            SPEED = 8;
        }

        if (KeyManager.killYourSelf){
            StateManager.setCurrentState(Engine.deadState);
        }

        // Update Bounding Box
        bounds.x = (int) x;
        bounds.y = (int) y;
    }

    @Override
    public void render(Graphics graphics) {
        // Pick the right frame to render
        graphics.drawImage(getCorrectFrame(), (int) x, (int) y, null);

        // Aura
        if (Effect_Aura.getIsActive()) {
            aura_eff.render(graphics, (int) x - 71, (int) y - 64);
        }

        // Speed
        if (speed_eff.getIsActive()) {
            speed_eff.render(graphics, (int) x - 71, (int) y - 64);
        }

        // Bounding box
        if (boundsToggle) {
            graphics.setColor(Color.GREEN);
            graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

    private BufferedImage getCorrectFrame() {

        if (KeyManager.left) {
            return player_walk_left.getCurrentFrame();
        }
        if (KeyManager.right) {
            return player_walk_right.getCurrentFrame();
        }
        return Assets.player_stand;
    }
}
