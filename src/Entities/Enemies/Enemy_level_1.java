package Entities.Enemies;

import Effects.Effect_Aura;
import Entities.Entity;
import Graphics.Assets;
import Main.Engine;
import States.GameState;
import States.StateManager;
import Utilities.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy_level_1 extends Entity {

    private float speed = Utilities.getRandom(1, 5);
    private static BufferedImage enemy = Assets.enemy;

    /**
     * Constructor
     *
     * @param x -> X Position
     * @param y -> Y Position
     */
    public Enemy_level_1(float x, float y) {
        super(x, y, Enemy_level_1.enemy.getWidth(), Enemy_level_1.enemy.getHeight());
    }

    /**
     * Ticks the current enemy object
     */
    @Override
    public void tick() {
        this.y += speed;

        // Update Bounding box
        bounds.x = (int) x;
        bounds.y = (int) y;

        // Check if there is an impact
        impactCheck();
    }

    /**
     * Renders the enemy to the screen
     *
     * @param graphics -> Required
     */
    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(enemy, (int) x, (int) y, null);

        // Test Collision
        if (boundsToggle) {
            graphics.setColor(Color.RED);
            graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

    private void impactCheck() {

        Rectangle playerBounds = EnemyController.gameState.getPlayer().bounds;
        boolean activeImpact = (y > 500) && Utilities.isInImpact(playerBounds, bounds) && isActive;

        // Impact
        if (activeImpact) {
            isActive = false;
            System.out.println("Impact");

            if (!Effect_Aura.getIsActive()){
                if (EnemyController.gameState.getPlayer().ARMOUR > 0) {
                    EnemyController.gameState.getPlayer().ARMOUR--;
                } else {
                    if (EnemyController.gameState.getPlayer().HEALTH > 0) {
                        EnemyController.gameState.getPlayer().HEALTH--;
                        // CHECK IF DEAD
                        if (EnemyController.gameState.getPlayer().HEALTH == 0) {
                            // THE PLAYER IS DEAD
                            EnemyController.gameState.getPlayer().isDead = true;
                            Utilities.sleep(2);
                            StateManager.setCurrentState(Engine.deadState);
                        }
                    }
                }
            }

            x = Utilities.getRandom(1, 896);
            y = Utilities.getRandom(200, 400);
            isActive = true;
        }
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
