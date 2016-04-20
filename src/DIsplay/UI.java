package DIsplay;

import Graphics.Assets;
import States.AllStates.GameState;

import java.awt.*;

public class UI {

    private GameState gameState;

    public UI(GameState state) {
        this.gameState = state;
    }

    private int time = 1000;

    public void tick() {
        time--;
    }

    /**
     * This method combines all the other render methods
     */
    public void render(Graphics graphics) {
        for (int i = 0; i < 3; i++) {
            graphics.drawImage(Assets.darken, 64 * i, 0, null);
            // graphics.drawImage(Assets.darken,64 * i,32,null);
        }
        renderHealth(graphics);
        renderArmour(graphics);
        renderPoints(graphics);
        renderPowerUps(graphics);
    }

    /**
     * This method will render the health power up
     */
    public void renderHealth(Graphics graphics) {
        int getPosition = 0;
        for (int i = 0; i < gameState.getPlayer().HEALTH; i++) {
            graphics.drawImage(Assets.health, 32 * i + 15, 10, null);
            getPosition = i + 1;
        }
        for (int i = getPosition; i < gameState.getPlayer().MAX_HEALTH - gameState.getPlayer().HEALTH + getPosition; i++) {
            graphics.drawImage(Assets.health_empty, 32 * i + 15, 10, null);
        }
    }

    /**
     * This method will render the armor power-up
     */
    public void renderArmour(Graphics graphics) {
        int getPosition = 0;
        for (int i = 0; i < gameState.getPlayer().ARMOUR; i++) {
            graphics.drawImage(Assets.armor, 32 * i + 15, 52, null);
            getPosition = i + 1;
        }
        for (int i = getPosition; i < gameState.getPlayer().MAX_ARMOUR - gameState.getPlayer().ARMOUR + getPosition; i++) {
            graphics.drawImage(Assets.armor_empty, 32 * i + 15, 52, null);
        }
    }

    /**
     * This method will render the points of the player
     */
    public void renderPoints(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 28));
        graphics.drawString("PTS: " + gameState.getPlayer().POINTS, 20, 123);
    }

    /**
     * This method will render the power-ips UI
     */
    public void renderPowerUps(Graphics graphics) {

        // Set font
        graphics.setColor(Color.white);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 28));

        // Render background
        for (int i = 11; i < 15; i++) {
            graphics.drawImage(Assets.darken, 64 * i, 0, null);
        }

        // Render Aura effect data
        if (gameState.getPlayer().aura_eff.getIsActive()) {
            graphics.drawString(gameState.getPlayer().aura_eff.getTimeLeft() + " ", 758, 47);
        } else {
            graphics.drawString("NONE", 728, 47);
        }

        // Render Speed effect data
        if (gameState.getPlayer().speed_eff.getIsActive()) {
            graphics.drawString(gameState.getPlayer().speed_eff.getTimeLeft() + " ", 758, 115);
        } else {
            graphics.drawString("NONE", 728, 45 + 70);
        }

        // Render power-ups icons
        graphics.drawImage(Assets.aura, 822, 4, null);
        graphics.drawImage(Assets.speed, 822, 70, null);
    }
}
