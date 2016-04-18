package Entities.Helping;

import States.GameState;
import Utilities.Utilities;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class BonusController {

    private LinkedList<Helping_health> health_drops = new LinkedList<>();
    private LinkedList<Helping_armor> armor_drops = new LinkedList<>();
    private LinkedList<Helping_aura> aura_drops = new LinkedList<>();
    private LinkedList<Helping_speed> speed_drops = new LinkedList<>();

    Random random = new Random();
    private Helping_health tempHealthObject;

    private GameState gameState;

    public BonusController(GameState gameState) {
        this.gameState = gameState;
    }

    public void createHealthObject(float healthObjectCount) {
        for (int i = 0; i < healthObjectCount; i++) {
            addHealthDrop(new Helping_health(random.nextInt(850),
                    Utilities.getRandom(3000,7000) * -1));
            addArmorDrop(new Helping_armor(random.nextInt(850),
                    Utilities.getRandom(7000,11000) * -1));
            addAuraDrop(new Helping_aura(random.nextInt(850),
                    Utilities.getRandom(11000,15000) * -1));
            addSpeedDrop(new Helping_speed(random.nextInt(850),
                    Utilities.getRandom(15000,19000) * -1));
        }
    }

    /**
     * Every frame ticks all the power-ups
     * Updates there values
     */
    public void tick() {

        // HEALTH
        for (Helping_health health_drop : health_drops) {
            int speed = Utilities.getRandom(1,3);
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(3000,7000);

            if (health_drop.getY() > 660) {
                // Set new values
                health_drop.setY(yPosition * -1);
                health_drop.setX(xPosition);
                health_drop.setSpeed(speed);
            }
            health_drop.tick();
        }

        // AURA
        for (Helping_aura aura_drop : aura_drops) {
            int speed = Utilities.getRandom(1,3);
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(7000,11000);

            if (aura_drop.getY() > 660) {
                // Set new values
                aura_drop.setY(yPosition * -1);
                aura_drop.setX(xPosition);
                aura_drop.setSpeed(speed);
            }
            aura_drop.tick();
        }

        // ARMOR
        for (Helping_armor armor_drop : armor_drops) {
            int speed = Utilities.getRandom(1,3);
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(11000,15000);

            if (armor_drop.getY() > 660) {
                // Set new values
                armor_drop.setY(yPosition * -1);
                armor_drop.setX(xPosition);
                armor_drop.setSpeed(speed);
            }
            armor_drop.tick();
        }

        // SPEED
        for (Helping_speed speed_drop : speed_drops) {
            int speed = Utilities.getRandom(1,3);
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(15000,19000);

            if (speed_drop.getY() > 660) {
                // Set new values
                speed_drop.setY(yPosition * -1);
                speed_drop.setX(xPosition);
                speed_drop.setSpeed(speed);
            }
            speed_drop.tick();
        }

    }

    /**
     * Render all the power-ups to the screen
     * @param graphics -> Required
     */
    public void render(Graphics graphics) {

        for (Helping_health health_drop : health_drops) {
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

    public void addHealthDrop(Helping_health drop) {
        health_drops.add(drop);
    }

    public void addArmorDrop(Helping_armor drop) {
        armor_drops.add(drop);
    }

    public void addAuraDrop(Helping_aura drop) {
        aura_drops.add(drop);
    }

    public void addSpeedDrop(Helping_speed drop) {
        speed_drops.add(drop);
    }

    public void removeHealthObject(Helping_health drop) {
        health_drops.remove(drop);
    }

}
