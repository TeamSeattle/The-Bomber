package Entities.Creature;

import java.awt.*;
import Graphics.Assets;

public class Player extends Creature {
    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        //Just use an existing Asset to image the player. When we decide, will change the image.
        graphics.drawImage(Assets.aura,(int) x, (int) y, null);
    }
}
