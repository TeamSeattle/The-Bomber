package Tiles.Backgrounds.Set1;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set1Hills extends Tile {

    public Set1Hills(int id) {
        super(Assets.set1_hills, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 13,64 * 15,null);
    }
}
