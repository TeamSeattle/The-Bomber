package Tiles.Backgrounds.Set4;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;


public class Set4Hills extends Tile {
    public Set4Hills(int id) {
        super(Assets.set4_hills, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 13,64 * 15,null);
    }
}
