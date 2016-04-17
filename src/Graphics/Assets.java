package Graphics;

import Utilities.Utilities;

import java.awt.image.BufferedImage;

// In assets is any image, sound or peace of a music
public class Assets {

    // Width and height of the images
    public static final int IMAGE_WIDTH = 64;
    public static final int IMAGE_HEIGHT = 64;

    // BROWN ASSETS
    public static BufferedImage brown_solid;
    public static BufferedImage brown_pattern_1;
    public static BufferedImage brown_pattern_2;
    public static BufferedImage brown_land_left;
    public static BufferedImage brown_land_middle;
    public static BufferedImage brown_land_right;
    public static BufferedImage brown_land_small;
    public static BufferedImage brown_platform_small;
    public static BufferedImage brown_platform_big;

    // YELLOW ASSETS
    public static BufferedImage yellow_solid;
    public static BufferedImage yellow_pattern_1;
    public static BufferedImage yellow_pattern_2;
    public static BufferedImage yellow_land_left;
    public static BufferedImage yellow_land_middle;
    public static BufferedImage yellow_land_right;
    public static BufferedImage yellow_land_small;
    public static BufferedImage yellow_platform_small;
    public static BufferedImage yellow_platform_big;

    // BLUE ASSETS
    public static BufferedImage blue_solid;
    public static BufferedImage blue_pattern_1;
    public static BufferedImage blue_pattern_2;
    public static BufferedImage blue_land_left;
    public static BufferedImage blue_land_middle;
    public static BufferedImage blue_land_right;
    public static BufferedImage blue_land_small;
    public static BufferedImage blue_platform_small;
    public static BufferedImage blue_platform_big;

    // GREEN ASSETS
    public static BufferedImage green_solid;
    public static BufferedImage green_pattern_1;
    public static BufferedImage green_pattern_2;
    public static BufferedImage green_land_left;
    public static BufferedImage green_land_middle;
    public static BufferedImage green_land_right;
    public static BufferedImage green_land_small;
    public static BufferedImage green_platform_small;
    public static BufferedImage green_platform_big;

    // PLANTS RED
    public static BufferedImage plat_red_1;
    public static BufferedImage plat_red_2;
    public static BufferedImage plat_red_3;
    public static BufferedImage plat_red_4;
    public static BufferedImage plat_red_5;
    public static BufferedImage plat_red_6;
    // PLANTS GREEN
    public static BufferedImage plat_green_1;
    public static BufferedImage plat_green_2;
    public static BufferedImage plat_green_3;
    public static BufferedImage plat_green_4;
    public static BufferedImage plat_green_5;
    public static BufferedImage plat_green_6;
    // PLANTS BLUE
    public static BufferedImage plat_blue_1;
    public static BufferedImage plat_blue_2;
    public static BufferedImage plat_blue_3;
    public static BufferedImage plat_blue_4;
    public static BufferedImage plat_blue_5;
    public static BufferedImage plat_blue_6;
    // PLANTS GRAY
    public static BufferedImage plat_gray_1;
    public static BufferedImage plat_gray_2;
    public static BufferedImage plat_gray_3;
    public static BufferedImage plat_gray_4;
    public static BufferedImage plat_gray_5;
    public static BufferedImage plat_gray_6;

    // WATER
    public static BufferedImage water;

    // ITEMS
    public static BufferedImage enemy;
    public static BufferedImage healthObject;

    // BACKGROUNDS
    public static BufferedImage set2_background;
    public static BufferedImage set2_hills;
    public static BufferedImage set2_tiles;
    public static BufferedImage realistic;
    public static BufferedImage menu_background;

    // EMPTY ASSETS USED FOR ERRORS
    public static BufferedImage empty;

    // PLAYER ASSETS
    public static BufferedImage player;
    public static BufferedImage health;
    public static BufferedImage armor;
    public static BufferedImage aura;
    public static BufferedImage speed;

    // MENU
    public static BufferedImage start_menu_button;
    public static BufferedImage close_menu_button;
    public static BufferedImage settings_menu_button;
    public static BufferedImage settings_button;

    /**
     * Its going to load everything in our game, and store in RAM
     */
    public static void initialize() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Assets_64x64.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Player/player.png"));

        // BROWN ASSETS
        brown_solid = sheet.crop(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_pattern_1 = sheet.crop(0, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_pattern_2 = sheet.crop(0, IMAGE_HEIGHT * 2, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_land_left = sheet.crop(IMAGE_WIDTH, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_land_middle = sheet.crop(IMAGE_WIDTH * 2, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_land_right = sheet.crop(IMAGE_WIDTH * 3, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_land_small = sheet.crop(IMAGE_WIDTH * 4, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        brown_platform_big = sheet.crop(IMAGE_WIDTH * 5, 0, IMAGE_WIDTH * 3, IMAGE_HEIGHT);
        brown_platform_small = sheet.crop(IMAGE_WIDTH * 8, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        // YELLOW ASSETS
        yellow_solid = sheet.crop(0, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_pattern_1 = sheet.crop(0, IMAGE_HEIGHT * 4, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_pattern_2 = sheet.crop(0, IMAGE_HEIGHT * 5, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_land_left = sheet.crop(IMAGE_WIDTH, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_land_middle = sheet.crop(IMAGE_WIDTH * 2, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_land_right = sheet.crop(IMAGE_WIDTH * 3, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_land_small = sheet.crop(IMAGE_WIDTH * 4, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        yellow_platform_big = sheet.crop(IMAGE_WIDTH * 5, IMAGE_HEIGHT * 3, IMAGE_WIDTH * 3, IMAGE_HEIGHT);
        yellow_platform_small = sheet.crop(IMAGE_WIDTH * 8, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);

        // BLUE ASSETS
        blue_solid = sheet.crop(0, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_pattern_1 = sheet.crop(0, IMAGE_HEIGHT * 7, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_pattern_2 = sheet.crop(0, IMAGE_HEIGHT * 8, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_land_left = sheet.crop(IMAGE_WIDTH, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_land_middle = sheet.crop(IMAGE_WIDTH * 2, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_land_right = sheet.crop(IMAGE_WIDTH * 3, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_land_small = sheet.crop(IMAGE_WIDTH * 4, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        blue_platform_big = sheet.crop(IMAGE_WIDTH * 5, IMAGE_HEIGHT * 6, IMAGE_WIDTH * 3, IMAGE_HEIGHT);
        blue_platform_small = sheet.crop(IMAGE_WIDTH * 8, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);

        // GREEN ASSETS
        green_solid = sheet.crop(0, IMAGE_HEIGHT * 9, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_pattern_1 = sheet.crop(0, IMAGE_HEIGHT * 10, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_pattern_2 = sheet.crop(0, IMAGE_HEIGHT * 11, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_land_left = sheet.crop(IMAGE_WIDTH, IMAGE_HEIGHT * 9, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_land_middle = sheet.crop(IMAGE_WIDTH * 2, IMAGE_HEIGHT * 9, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_land_right = sheet.crop(IMAGE_WIDTH * 3, IMAGE_HEIGHT * 9, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_land_small = sheet.crop(IMAGE_WIDTH * 4, IMAGE_HEIGHT * 9, IMAGE_WIDTH, IMAGE_HEIGHT);
        green_platform_big = sheet.crop(IMAGE_WIDTH * 5, IMAGE_HEIGHT * 9, IMAGE_WIDTH * 3, IMAGE_HEIGHT);
        green_platform_small = sheet.crop(IMAGE_WIDTH * 8, IMAGE_HEIGHT * 9, IMAGE_WIDTH, IMAGE_HEIGHT);

        // PLANTS RED
        plat_red_1 = sheet.crop(IMAGE_WIDTH * 9, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_red_2 = sheet.crop(IMAGE_WIDTH * 10, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_red_3 = sheet.crop(IMAGE_WIDTH * 11, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_red_4 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_red_5 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_red_6 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
        // PLANTS GREEN
        plat_green_1 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT * 2, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_green_2 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT * 2, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_green_3 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT * 2, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_green_4 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_green_5 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_green_6 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT * 3, IMAGE_WIDTH, IMAGE_HEIGHT);
        // PLANTS BLUE
        plat_blue_1 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT * 4, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_blue_2 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT * 4, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_blue_3 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT * 4, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_blue_4 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT * 5, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_blue_5 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT * 5, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_blue_6 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT * 5, IMAGE_WIDTH, IMAGE_HEIGHT);
        // PLANTS GRAY
        plat_gray_1 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_gray_2 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_gray_3 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_gray_4 = sheet.crop(IMAGE_WIDTH * 9, IMAGE_HEIGHT * 7, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_gray_5 = sheet.crop(IMAGE_WIDTH * 10, IMAGE_HEIGHT * 7, IMAGE_WIDTH, IMAGE_HEIGHT);
        plat_gray_6 = sheet.crop(IMAGE_WIDTH * 11, IMAGE_HEIGHT * 7, IMAGE_WIDTH, IMAGE_HEIGHT);

        // WATER
        water = sheet.crop(IMAGE_WIDTH * 12, IMAGE_HEIGHT * 10, IMAGE_WIDTH, IMAGE_HEIGHT * 2);

        // ITEMS and Scale to 64x64
        enemy = ImageLoader.loadImage("/textures/Enemies/enemyFloating_1.png");
        empty = sheet.crop(IMAGE_WIDTH * 16, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        healthObject = ImageLoader.loadImage("/textures/Enemies/health.png");

        // BACKGROUNDS
        set2_background = ImageLoader.loadImage("/textures/Backgrounds/set2_background.png");
        set2_hills = ImageLoader.loadImage("/textures/Backgrounds/set2_hills.png");
        set2_tiles = ImageLoader.loadImage("/textures/Backgrounds/set2_tiles.png");
        realistic = ImageLoader.loadImage("/textures/Backgrounds/realistic.png");
        menu_background = ImageLoader.loadImage("/textures/Backgrounds/menu_background.png");
        menu_background = Utilities.scale(menu_background, 1.2, 0.8);

        // PLAYER
        player = playerSheet.crop(128,128,64,64);
        health = ImageLoader.loadImage("/textures/Player/health.png");
        health = Utilities.scale(health, 0.2, 0.2);
        armor = ImageLoader.loadImage("/textures/Player/armor.png");
        armor = Utilities.scale(armor, 0.2, 0.2);
        speed = ImageLoader.loadImage("/textures/Player/speed.png");
        speed = Utilities.scale(speed, 0.5, 0.5);
        aura = ImageLoader.loadImage("/textures/Player/aura.png");
        aura = Utilities.scale(aura, 0.5, 0.5);

        // MENU
        start_menu_button = ImageLoader.loadImage("/textures/Menu/Button_newgame.png");
        close_menu_button = ImageLoader.loadImage("/textures/Menu/Button_exit.png");
        settings_menu_button = ImageLoader.loadImage("/textures/menu/Button_settings.png");
        settings_button = ImageLoader.loadImage("/textures/menu/settings-9.png");

        printInfo();
    }

    private static void printInfo() {
        System.out.println("All assets loaded successfully!");
    }
}
