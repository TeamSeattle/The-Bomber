package Entities.Creature;

import java.awt.*;

import Graphics.Assets;
import Main.Engine;

public class Player extends Creature {

    private Engine engine;

    public Player(Engine engine,float x, float y) {
        super(x, y);
        this.engine=engine;
    }

    @Override
    public void tick() {
        if (engine.getKeyManager().left){
            x-=speed;
        }if (engine.getKeyManager().right){
            x+=speed;
        }
    }

    @Override
    public void render(Graphics graphics) {
        //Just use an existing Asset to image the player. When we decide, will change the image.
        graphics.drawImage(Assets.aura, (int) x, (int) y, null);
    }
}
