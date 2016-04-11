package Tiles;

import Tiles.Blue.*;
import Tiles.Brown.*;
import Tiles.Green.*;
import Tiles.Yellow.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //Static stuff here, if array is not enough length change it.
    public static Tile[] tiles = new Tile[256];

    // BROWN TILES
    public static Tile brown_solid= new BrownSolid(0);
    public static Tile brown_pattern_1= new BrownPattern1(1);
    public static Tile brown_pattern_2= new BrownPattern2(2);
    public static Tile brown_land_left= new BrownLandLeft(3);
    public static Tile brown_land_middle= new BrownLandMiddle(4);
    public static Tile brown_land_right= new BrownLandRight(5);
    public static Tile brown_land_small= new BrownLandSmall(6);
    public static Tile brown_platform_big= new BrownPlatformBig(7);
    public static Tile brown_platform_small= new BrownPlatformSmall(8);
    // YELLOW TILES
    public static Tile yellow_solid= new YellowSolid(10);
    public static Tile yellow_pattern_1= new YellowPattern1(11);
    public static Tile yellow_pattern_2= new YellowPattern2(12);
    public static Tile yellow_land_left= new YellowLandLeft(13);
    public static Tile yellow_land_middle= new YellowLandMiddle(14);
    public static Tile yellow_land_right= new YellowLandRight(15);
    public static Tile yellow_land_small= new YellowLandSmall(16);
    public static Tile yellow_platform_big= new YellowPlatformBig(17);
    public static Tile yellow_platform_small= new YellowPlatformSmall(18);
    // BLUE ASSETS
    public static Tile blue_solid= new BlueSolid(20);
    public static Tile blue_pattern_1= new BluePattern1(21);
    public static Tile blue_pattern_2= new BluePattern2(22);
    public static Tile blue_land_left= new BlueLandLeft(23);
    public static Tile blue_land_middle= new BlueLandMiddle(24);
    public static Tile blue_land_right= new BlueLandRight(25);
    public static Tile blue_land_small= new BlueLandSmall(26);
    public static Tile blue_platform_big= new BluePlatformBig(27);
    public static Tile blue_platform_small= new BluePlatformSmall(28);
    // GREEN ASSETS
    public static Tile green_solid= new GreenSolid(30);
    public static Tile green_pattern_1= new GreenPattern1(31);
    public static Tile green_pattern_2= new GreenPattern2(32);
    public static Tile green_land_left= new GreenLandLeft(33);
    public static Tile green_land_middle= new GreenLandMiddle(34);
    public static Tile green_land_right= new GreenLandRight(35);
    public static Tile green_land_small= new GreenLandSmall(36);
    public static Tile green_platform_big= new GreenPlatformBig(37);
    public static Tile green_platform_small= new GreenPlatformSmall(38);


    //Class
    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;

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
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public int getId() {
        return id;
    }
}
