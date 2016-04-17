package Tiles.Backgrounds;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;


public class Set2Hills extends Tile {
    public Set2Hills(int id) {
        super(Assets.set2_hills, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 13,64 * 15,null);
    }
}
