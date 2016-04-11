package Tiles;

import Tiles.Brown.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //Static stuff here, if array is not enough lenght change it.
    public static Tile[] tiles = new Tile[256];
    public static Tile brown_solid= new BrownSolid(0);
    public static Tile brown_pattern_1= new BrownPattern1(1);
    public static Tile brown_pattern_2= new BrownPattern1(2);
    public static Tile brown_land_left= new BrownLandLeft(3);
    public static Tile brown_land_middle= new BrownLandMiddle(4);
    public static Tile brown_land_right= new BrownLandRight(5);
    public static Tile brown_land_small= new BrownLandSmall(6);
    public static Tile brown_platform_big= new BrownPlatformBig(7);
    public static Tile brown_platform_small= new BrownPlatformSmall(8);



    //Class

    public static final int TILEWIDTH = 64;
    public static final int TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;


    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id]= this;
    }

    public void tick() {

    }

    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
}
