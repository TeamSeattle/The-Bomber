package gfx;

import java.awt.image.BufferedImage;

// In assets is any image, sound or peace of a music
public class Assets {
    //The width and height of the different pictures in sheet. or pixels
    private static final int width = 32;
    private static final int height = 32;

    public static BufferedImage player, dirt, grass, stone, tree;

    //Its going to load everything in our game, and make it once
    //It's loaded a test sheet, just to see if it's working..When we decide what will be the
    //theme of the background and etc. will change it.

    public static void initialize() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test_sheet.png"));
        player = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        stone = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);
    }
}
