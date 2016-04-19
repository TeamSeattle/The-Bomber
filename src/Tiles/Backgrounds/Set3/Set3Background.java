package Tiles.Backgrounds.Set3;

import Graphics.Assets;
import Tiles.Tile;

import java.awt.*;

public class Set3Background extends Tile {

    public Set3Background(int id) {
        super(Assets.set3_background, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture,0,0,64 * 14,64 * 15,null);
    }
}
