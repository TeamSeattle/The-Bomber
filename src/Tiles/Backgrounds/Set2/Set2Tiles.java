package Tiles.Backgrounds.Set2;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set2Tiles extends Tile {
    public Set2Tiles(int id) {
        super(Assets.set2_tiles, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 12,null);
    }
}
