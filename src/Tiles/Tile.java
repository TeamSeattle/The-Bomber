package Tiles;

import Tiles.Backgrounds.Realistic;
import Tiles.Backgrounds.Set2Background;
import Tiles.Backgrounds.Set2Hills;
import Tiles.Backgrounds.Set2Tiles;
import Tiles.Blue.*;
import Tiles.Brown.*;
import Tiles.Green.*;
import Tiles.Items.Armor;
import Tiles.Items.Aura;
import Tiles.Items.Health;
import Tiles.Items.Speed;
import Tiles.Others.Empty;
import Tiles.Plants.Blue.*;
import Tiles.Plants.Gray.*;
import Tiles.Plants.Green.*;
import Tiles.Plants.Red.*;
import Tiles.Water.Water;
import Tiles.Yellow.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //Static stuff here, if array is not enough length change it.
    public static Tile[] tiles = new Tile[256];

    // OTHER
    public static Tile empty = new Empty(0);

    // BROWN TILES
    public static Tile brown_solid = new BrownSolid(1);
    public static Tile brown_pattern_1 = new BrownPattern1(2);
    public static Tile brown_pattern_2 = new BrownPattern2(3);
    public static Tile brown_land_left = new BrownLandLeft(4);
    public static Tile brown_land_middle = new BrownLandMiddle(5);
    public static Tile brown_land_right = new BrownLandRight(6);
    public static Tile brown_land_small = new BrownLandSmall(7);
    public static Tile brown_platform_big = new BrownPlatformBig(8);
    public static Tile brown_platform_small = new BrownPlatformSmall(9);
    // YELLOW TILES
    public static Tile yellow_solid = new YellowSolid(10);
    public static Tile yellow_pattern_1 = new YellowPattern1(11);
    public static Tile yellow_pattern_2 = new YellowPattern2(12);
    public static Tile yellow_land_left = new YellowLandLeft(13);
    public static Tile yellow_land_middle = new YellowLandMiddle(14);
    public static Tile yellow_land_right = new YellowLandRight(15);
    public static Tile yellow_land_small = new YellowLandSmall(16);
    public static Tile yellow_platform_big = new YellowPlatformBig(17);
    public static Tile yellow_platform_small = new YellowPlatformSmall(18);
    // BLUE ASSETS
    public static Tile blue_solid = new BlueSolid(20);
    public static Tile blue_pattern_1 = new BluePattern1(21);
    public static Tile blue_pattern_2 = new BluePattern2(22);
    public static Tile blue_land_left = new BlueLandLeft(23);
    public static Tile blue_land_middle = new BlueLandMiddle(24);
    public static Tile blue_land_right = new BlueLandRight(25);
    public static Tile blue_land_small = new BlueLandSmall(26);
    public static Tile blue_platform_big = new BluePlatformBig(27);
    public static Tile blue_platform_small = new BluePlatformSmall(28);
    // GREEN ASSETS
    public static Tile green_solid = new GreenSolid(30);
    public static Tile green_pattern_1 = new GreenPattern1(31);
    public static Tile green_pattern_2 = new GreenPattern2(32);
    public static Tile green_land_left = new GreenLandLeft(33);
    public static Tile green_land_middle = new GreenLandMiddle(34);
    public static Tile green_land_right = new GreenLandRight(35);
    public static Tile green_land_small = new GreenLandSmall(36);
    public static Tile green_platform_big = new GreenPlatformBig(37);
    public static Tile green_platform_small = new GreenPlatformSmall(38);

    //PLANTS RED
    public static Tile plat_red_1 = new PlatRed1(40);
    public static Tile plat_red_2 = new PlatRed2(41);
    public static Tile plat_red_3 = new PlatRed3(42);
    public static Tile plat_red_4 = new PlatRed4(43);
    public static Tile plat_red_5 = new PlatRed5(44);
    public static Tile plat_red_6 = new PlatRed6(45);

    //PLANTS GREEN
    public static Tile plat_green_1 = new PlatGreen1(50);
    public static Tile plat_green_2 = new PlatGreen2(51);
    public static Tile plat_green_3 = new PlatGreen3(52);
    public static Tile plat_green_4 = new PlatGreen4(53);
    public static Tile plat_green_5 = new PlatGreen5(54);
    public static Tile plat_green_6 = new PlatGreen6(55);

    //PLANTS BLUE
    public static Tile plat_blue_1 = new PlatBlue1(60);
    public static Tile plat_blue_2 = new PlatBlue2(61);
    public static Tile plat_blue_3 = new PlatBlue3(62);
    public static Tile plat_blue_4 = new PlatBlue4(63);
    public static Tile plat_blue_5 = new PlatBlue5(64);
    public static Tile plat_blue_6 = new PlatBlue6(65);

    //PLANTS GRAY
    public static Tile plat_gray_1 = new PlatGray1(70);
    public static Tile plat_gray_2 = new PlatGray2(71);
    public static Tile plat_gray_3 = new PlatGray3(72);
    public static Tile plat_gray_4 = new PlatGray4(73);
    public static Tile plat_gray_5 = new PlatGray5(74);
    public static Tile plat_gray_6 = new PlatGray6(75);

    //WATER
    public static Tile water = new Water(80);

    //ITEMS
    public static Tile aura = new Aura(90);
    public static Tile health = new Health(91);
    public static Tile speed = new Speed(92);
    public static Tile armor = new Armor(93);

    //BACKGROUNDS
    public static Tile set2_background= new Set2Background(100);
    public static Tile set2_hills = new Set2Hills(101);
    public static Tile set2_tiles = new Set2Tiles(102);
    public static Tile realistic = new Realistic(103);

    // Class
    // =====================================
    // Properties
    public static int TILE_WIDTH = 64;
    public static int TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    /**
     * Constructor
     * @param texture -> Buffered Image / Texture
     * @param id -> Id of the tile
     */
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }


    /**
     * This method is called every frame before a tile
     * needs to be rendered
     */
    public void tick() {

    }


    /**
     * This method is called every frame when a tile
     * needs to be rendered
     * @param graphics -> Graphics Object
     * @param x -> X Position
     * @param y -> Y Position
     */
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }


    /**
     * Get the id of the tile
     * @return -> int with Id
     */
    public int getId() {
        return id;
    }
}
