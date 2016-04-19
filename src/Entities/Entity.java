package Entities;

import java.awt.*;

public abstract class Entity {
    // Position
    protected float x;
    protected float y;

    // Bounds
    public Rectangle bounds;
    protected int width;
    protected int height;

    // Bounds controller
    public static boolean boundsToggle;

    // State of Enemy
    protected boolean isActive;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        bounds = new Rectangle((int) x, (int) y, width, height);

        boundsToggle = false;

        isActive = true;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
