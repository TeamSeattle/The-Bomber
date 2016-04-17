package Tiles.Backgrounds;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Realistic extends Tile {
    /**
     * Constructor
     * @param id      -> Id of the tile
     */
    public Realistic(int id) {
        super(Assets.realistic, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 10,null);
    }
}
