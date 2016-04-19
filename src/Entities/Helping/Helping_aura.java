package Entities.Helping;

import Entities.Entity;
import Graphics.Assets;
import Utilities.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Helping_aura extends Entity {

    protected float speed = Utilities.getRandom(1, 5);
    private static BufferedImage aura = Assets.aura;

    public Helping_aura(float x, float y) {
        super(x, y, aura.getWidth(), aura.getHeight());
    }

    /**
     * Ticks the current power-up object
     */
    @Override
    public void tick() {
        y += speed;

        // Update Bounding box
        bounds.x = (int) x;
        bounds.y = (int) y;
    }

    /**
     * Renders the current power-up to the screen
     *
     * @param graphics -> Required
     */
    @Override
    public void render(Graphics graphics) {
        // Render Effect
        graphics.drawImage(aura, (int) x, (int) y, null);
        // Bounding box
        if (boundsToggle) {
            graphics.setColor(Color.BLUE);
            graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
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
