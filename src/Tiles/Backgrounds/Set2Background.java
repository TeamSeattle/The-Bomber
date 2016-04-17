package Tiles.Backgrounds;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set2Background extends Tile {

    public Set2Background(int id) {
        super(Assets.set2_background, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 15,null);
    }
}
