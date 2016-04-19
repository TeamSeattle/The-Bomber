package Tiles.Backgrounds.Set3;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set3Tiles extends Tile {
    public Set3Tiles(int id) {
        super(Assets.set3_tiles, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 12,null);
    }
}
