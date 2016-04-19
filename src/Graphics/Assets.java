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
    public static BufferedImage water_blue;
    public static BufferedImage water_green;
    public static BufferedImage water_red;
    public static BufferedImage water_brown;

    // ITEMS
    public static BufferedImage enemy;
    public static BufferedImage healthObject;

    // BACKGROUNDS
    public static BufferedImage set1_background;
    public static BufferedImage set1_hills;
    public static BufferedImage set1_tiles;

    public static BufferedImage set2_background;
    public static BufferedImage set2_hills;
    public static BufferedImage set2_tiles;

    public static BufferedImage set3_background;
    public static BufferedImage set3_hills;
    public static BufferedImage set3_tiles;

    public static BufferedImage set4_background;
    public static BufferedImage set4_hills;
    public static BufferedImage set4_tiles;

    public static BufferedImage menu_background;
    public static BufferedImage darken;

    // EMPTY ASSETS USED FOR ERRORS
    public static BufferedImage empty;

    // PLAYER ASSETS
    public static BufferedImage player_stand;
    public static BufferedImage[] player_walk_right;
    public static BufferedImage[] player_walk_left;

    public static BufferedImage player_walk_right_1;
    public static BufferedImage player_walk_left_1;
    public static BufferedImage player_walk_right_2;
    public static BufferedImage player_walk_left_2;
    public static BufferedImage health;
    public static BufferedImage health_empty;
    public static BufferedImage armor;
    public static BufferedImage armor_empty;
    public static BufferedImage aura;
    public static BufferedImage aura_on_player;
    public static BufferedImage speed;
    public static BufferedImage speed_icon;

    // MENU
    public static BufferedImage start_menu_button;
    public static BufferedImage start_menu_button_hover;
    public static BufferedImage close_menu_button;
    public static BufferedImage close_menu_button_hover;
    public static BufferedImage settings_menu_button;
    public static BufferedImage settings_menu_button_hover;
    public static BufferedImage resume_menu_button;
    public static BufferedImage resume_menu_button_hover;
    public static BufferedImage volume_on_menu_button;
    public static BufferedImage volume_on_menu_button_hover;
    public static BufferedImage volume_off_menu_button;
    public static BufferedImage volume_off_menu_button_hover;
    public static BufferedImage to_main_menu;
    public static BufferedImage to_main_menu_hover;

    // IN-GAME
    public static BufferedImage in_game_settings;

    /**
     * Its going to load everything in our game, and store in RAM
     */
    public static void initialize() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Assets_64x64.png"));

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
        water_blue = sheet.crop(IMAGE_WIDTH * 12, IMAGE_HEIGHT * 10, IMAGE_WIDTH, IMAGE_HEIGHT * 2);
        water_green = sheet.crop(IMAGE_WIDTH * 13, IMAGE_HEIGHT * 10, IMAGE_WIDTH, IMAGE_HEIGHT * 2);
        water_red = sheet.crop(IMAGE_WIDTH * 14, IMAGE_HEIGHT * 10, IMAGE_WIDTH, IMAGE_HEIGHT * 2);
        water_brown = sheet.crop(IMAGE_WIDTH * 15, IMAGE_HEIGHT * 10, IMAGE_WIDTH, IMAGE_HEIGHT * 2);

        // ITEMS and Scale to 64x64
        enemy = ImageLoader.loadImage("/textures/Enemies/enemyFloating_1.png");
        empty = sheet.crop(IMAGE_WIDTH * 16, IMAGE_HEIGHT * 6, IMAGE_WIDTH, IMAGE_HEIGHT);
        healthObject = ImageLoader.loadImage("/textures/Enemies/health.png");

        // BACKGROUNDS
        set1_background = ImageLoader.loadImage("/textures/Backgrounds/set1_background.png");
        set1_hills = ImageLoader.loadImage("/textures/Backgrounds/set1_hills.png");
        set1_tiles = ImageLoader.loadImage("/textures/Backgrounds/set1_tiles.png");

        set2_background = ImageLoader.loadImage("/textures/Backgrounds/set2_background.png");
        set2_hills = ImageLoader.loadImage("/textures/Backgrounds/set2_hills.png");
        set2_tiles = ImageLoader.loadImage("/textures/Backgrounds/set2_tiles.png");

        set3_background = ImageLoader.loadImage("/textures/Backgrounds/set3_background.png");
        set3_hills = ImageLoader.loadImage("/textures/Backgrounds/set3_hills.png");
        set3_tiles = ImageLoader.loadImage("/textures/Backgrounds/set3_tiles.png");

        set4_background = ImageLoader.loadImage("/textures/Backgrounds/set4_background.png");
        set4_hills = ImageLoader.loadImage("/textures/Backgrounds/set4_hills.png");
        set4_tiles = ImageLoader.loadImage("/textures/Backgrounds/set4_tiles.png");

        // MENU BACKGROUND
        menu_background = ImageLoader.loadImage("/textures/Backgrounds/menu_background.png");
        menu_background = Utilities.scaleImage(menu_background, 1.245, 1.13);
        darken = ImageLoader.loadImage("/textures/Backgrounds/darken.png");

        // PLAYER
        player_stand = ImageLoader.loadImage("/textures/Player/player_stand.png");
        player_walk_right_1 = ImageLoader.loadImage("/textures/Player/player_walk_1.png");
        player_walk_right_2 = ImageLoader.loadImage("/textures/Player/player_walk_2.png");
        player_walk_left_1 = Utilities.flipImage(player_walk_right_1);
        player_walk_left_2 = Utilities.flipImage(player_walk_right_2);
        // PLAYER ANIMATIONS
        player_walk_right = new BufferedImage[2];
        player_walk_left = new BufferedImage[2];
        // FILL ARRAYS
        player_walk_right[0] = player_walk_right_1;
        player_walk_right[1] = player_walk_right_2;
        player_walk_left[0] = player_walk_left_1;
        player_walk_left[1] = player_walk_left_2;
        // PLAYER OTHERS
        health = ImageLoader.loadImage("/textures/Player/health.png");
        health_empty = ImageLoader.loadImage("/textures/Player/heart_empty.png");
        armor = ImageLoader.loadImage("/textures/Player/armor.png");
        armor_empty = ImageLoader.loadImage("/textures/Player/armor_empty.png");
        speed = ImageLoader.loadImage("/textures/Player/speed.png");
        speed_icon = ImageLoader.loadImage("/textures/Player/speed_icon.png");
        aura = ImageLoader.loadImage("/textures/Player/aura.png");
        aura_on_player = ImageLoader.loadImage("/textures/Player/aura_player.png");

        // MENU
        start_menu_button = ImageLoader.loadImage("/textures/Menu/Button_newgame.png");
        close_menu_button = ImageLoader.loadImage("/textures/Menu/Button_exit.png");
        settings_menu_button = ImageLoader.loadImage("/textures/menu/Button_settings.png");
        resume_menu_button = ImageLoader.loadImage("/textures/Menu/Button_unpause.png");
        volume_on_menu_button = ImageLoader.loadImage("/textures/Menu/Button_volume_on.png");
        volume_off_menu_button = ImageLoader.loadImage("/textures/Menu/Button_volume_off.png");
        in_game_settings = ImageLoader.loadImage("/textures/menu/settings-9.png");
        to_main_menu = ImageLoader.loadImage("/textures/menu/Button_to_main_menu.png");

        // HOVER
        start_menu_button_hover = ImageLoader.loadImage("/textures/Menu/Button_newgame_hover.png");
        close_menu_button_hover = ImageLoader.loadImage("/textures/Menu/Button_exit_hover.png");
        settings_menu_button_hover = ImageLoader.loadImage("/textures/menu/Button_settings_hover.png");
        resume_menu_button_hover = ImageLoader.loadImage("/textures/Menu/Button_unpause_hover.png");
        volume_on_menu_button_hover = ImageLoader.loadImage("/textures/Menu/Button_volume_on_hover.png");
        volume_off_menu_button_hover = ImageLoader.loadImage("/textures/Menu/Button_volume_off_hover.png");
        to_main_menu_hover = ImageLoader.loadImage("/textures/menu/Button_to_main_menu_hover.png");

        printInfo();
    }

    private static void printInfo() {
        System.out.println("All assets loaded successfully!");
    }
}
