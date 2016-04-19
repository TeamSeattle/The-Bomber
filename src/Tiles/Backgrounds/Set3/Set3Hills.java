package Tiles.Backgrounds.Set3;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;


public class Set3Hills extends Tile {
    public Set3Hills(int id) {
        super(Assets.set3_hills, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 13,64 * 15,null);
    }
}
