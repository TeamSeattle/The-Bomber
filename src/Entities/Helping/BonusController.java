package Entities.Helping;

import States.AllStates.GameState;
import Utilities.Utilities;

import java.awt.*;
import java.util.LinkedList;

public class BonusController {

    private LinkedList<Helping_Health> health_drops = new LinkedList<Helping_Health>();
    private LinkedList<Helping_armor> armor_drops = new LinkedList<Helping_armor>();
    private LinkedList<Helping_aura> aura_drops = new LinkedList<Helping_aura>();
    private LinkedList<Helping_speed> speed_drops = new LinkedList<Helping_speed>();

    // VALUES
    private int yMin = 3000;
    private int yMax = 15000;

    private int xMin = 1;
    private int xMax = 864;

    private int speedMin = 1;
    private int speedMax = 4;

    // SYSTEM DATA
    public static GameState gameState;

    // DEADLINE
    private static final int DEAD_LINE = 700;

    public BonusController(GameState gameState) {
        this.gameState = gameState;
    }

    public void createBonuses(float healthObjectCount) {
        for (int i = 0; i < healthObjectCount; i++) {

            addHealthDrop(new Helping_Health(
                    Utilities.getRandom(xMin, xMax),         // x
                    Utilities.getRandom(yMin, yMax) * -1));  // y
            addArmorDrop(new Helping_armor(
                    Utilities.getRandom(xMin, xMax),         // x
                    Utilities.getRandom(yMin, yMax) * -1));  // y
            addAuraDrop(new Helping_aura(
                    Utilities.getRandom(xMin, xMax),         // x
                    Utilities.getRandom(yMin, yMax) * -1));  // y
            addSpeedDrop(new Helping_speed(
                    Utilities.getRandom(xMin, xMax),         // x
                    Utilities.getRandom(yMin, yMax) * -1));  // y
        }
    }

    /**
     * Every frame ticks all the power-ups
     * Updates there values
     */
    public void tick() {
        tickHealth();
        tickArmor();
        tickAura();
        tickSpeed();
    }

    /**
     * Render all the power-ups to the screen
     *
     * @param graphics -> Required
     */
    public void render(Graphics graphics) {

        for (Helping_Health health_drop : health_drops) {
            health_drop.render(graphics);
        }

        for (Helping_armor armor_drop : armor_drops) {
            armor_drop.render(graphics);
        }

        for (Helping_aura aura_drop : aura_drops) {
            aura_drop.render(graphics);
        }

        for (Helping_speed speed_drop : speed_drops) {
            speed_drop.render(graphics);
        }
    }

    /**
     * This Method will tick the health drop
     */
    private void tickHealth() {
        // HEALTH
        for (Helping_Health health_drop : health_drops) {

            // Values
            int speed = Utilities.getRandom(speedMin, speedMax);
            int xPosition = Utilities.getRandom(xMin, xMax);
            int yPosition = Utilities.getRandom(yMin, yMax);

            if (health_drop.getY() > DEAD_LINE) {
                // Set new values
                health_drop.setY(yPosition * -1);
                health_drop.setX(xPosition);
                health_drop.setSpeed(speed);
            }
            health_drop.tick();
        }
    }

    /**
     * This Method will tick the aura drop
     */
    private void tickAura() {
        // AURA
        for (Helping_aura aura_drop : aura_drops) {

            // Values
            int speed = Utilities.getRandom(speedMin, speedMax);
            int xPosition = Utilities.getRandom(xMin, xMax);
            int yPosition = Utilities.getRandom(yMin, yMax);

            if (aura_drop.getY() > DEAD_LINE) {
                // Set new values
                aura_drop.setY(yPosition * -1);
                aura_drop.setX(xPosition);
                aura_drop.setSpeed(speed);
            }
            aura_drop.tick();
        }
    }

    /**
     * This Method will tick the armor drop
     */
    private void tickArmor() {
        // ARMOR
        for (Helping_armor armor_drop : armor_drops) {

            // Values
            int speed = Utilities.getRandom(speedMin, speedMax);
            int xPosition = Utilities.getRandom(xMin, xMax);
            int yPosition = Utilities.getRandom(yMin, yMax);

            if (armor_drop.getY() > DEAD_LINE) {
                // Set new values
                armor_drop.setY(yPosition * -1);
                armor_drop.setX(xPosition);
                armor_drop.setSpeed(speed);
            }
            armor_drop.tick();
        }
    }

    /**
     * This Method will tick the speed drop
     */
    private void tickSpeed() {
        // SPEED
        for (Helping_speed speed_drop : speed_drops) {

            // Values
            int speed = Utilities.getRandom(speedMin, speedMax);
            int xPosition = Utilities.getRandom(xMin, xMax);
            int yPosition = Utilities.getRandom(yMin, yMax);

            if (speed_drop.getY() > DEAD_LINE) {
                // Set new values
                speed_drop.setY(yPosition * -1);
                speed_drop.setX(xPosition);
                speed_drop.setSpeed(speed);
            }
            speed_drop.tick();
        }
    }

    private void addHealthDrop(Helping_Health drop) {
        health_drops.add(drop);
    }

    private void addArmorDrop(Helping_armor drop) {
        armor_drops.add(drop);
    }

    private void addAuraDrop(Helping_aura drop) {
        aura_drops.add(drop);
    }

    private void addSpeedDrop(Helping_speed drop) {
        speed_drops.add(drop);
    }
}
