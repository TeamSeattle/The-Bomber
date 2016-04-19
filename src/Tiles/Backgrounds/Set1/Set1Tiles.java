package Tiles.Backgrounds.Set1;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set1Tiles extends Tile{

    public Set1Tiles(int id) {
        super(Assets.set1_tiles, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 12,null);
    }
}
