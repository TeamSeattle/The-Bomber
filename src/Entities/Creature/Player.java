package Entities.Creature;

import DIsplay.Display;
import Effects.Effect_Aura;
import Effects.Effect_Speed;
import Entities.Entity;
import Graphics.Assets;
import Graphics.Animation;
import Input.KeyManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    // Properties of the player
    public int HEALTH;
    public int MAX_HEALTH;
    public float SPEED;
    public int ARMOUR;
    public int MAX_ARMOUR;

    // Animations
    private Animation player_walk_right;
    private Animation player_walk_left;

    // Effects
    protected Effect_Aura aura_eff;
    protected Effect_Speed speed_eff;

    /**
     * Constructor
     *
     * @param x      -> position on X axis
     * @param y      -> position on Y axis
     */
    public Player(float x, float y) {
        super(x, y);

        // Initialize properties
        HEALTH = 2;
        MAX_HEALTH = 5;
        ARMOUR = 3;
        MAX_ARMOUR = 5;
        SPEED = 8F;

        // Animations
        player_walk_left = new Animation(200,Assets.player_walk_left);
        player_walk_right = new Animation(200,Assets.player_walk_right);

        // Initialize effects
        aura_eff = new Effect_Aura(false);
        speed_eff = new Effect_Speed(false);
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
            if (x < Display.WINDOW_WIDTH -56) {
                x += SPEED;
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

        // Temporary to test the SPEED effect
        if (KeyManager.speedSwitch) {
            speed_eff.setIsActive(true);
            SPEED = 20;
        }
        if (speed_eff.getIsActive()) {
            speed_eff.tick();
            System.out.println("Effect_Speed tick");
        } else SPEED = 8f;
    }

    @Override
    public void render(Graphics graphics) {
        //Just use an existing Asset to image the player. When we decide, will change the image.
        graphics.drawImage(getCorrectFrame(), (int) x, (int) y, null);

        // Aura
        if (aura_eff.getIsActive()) {
            aura_eff.render(graphics, (int) x - 71, (int) y - 64);
        }

        // Speed
        if (speed_eff.getIsActive()) {
            speed_eff.render(graphics, (int) x - 71, (int) y - 64);
        }
    }

    private BufferedImage getCorrectFrame(){

        if (KeyManager.left){
            return player_walk_left.getCurrentFrame();
        }
        if (KeyManager.right){
            return player_walk_right.getCurrentFrame();
        }
        return Assets.player_stand;
    }
}
