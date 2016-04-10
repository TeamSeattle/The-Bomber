package Entities;

import java.awt.*;

public abstract class Entity {
    // It's float because this is how we achieve a smooth movement in our game
    protected float x;
    protected float y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);
}
