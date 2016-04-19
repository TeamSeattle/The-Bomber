package Tiles.Backgrounds.Set1;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set1Background extends Tile{

    public Set1Background(int id) {
        super(Assets.set1_background, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 15,null);
    }
}
