package Tiles.Water;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Water extends Tile{
    public Water(int id) {
        super(Assets.water, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        super.render(graphics, x, y);
    }
}
