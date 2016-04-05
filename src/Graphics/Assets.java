package Graphics;

import java.awt.image.BufferedImage;

// In assets is any image, sound or peace of a music
public class Assets {

    // Width and height of the images
    private static final int IMAGE_WIDTH = 32;
    private static final int IMAGE_HEIGHT = 32;

    // Assets
    public static BufferedImage player;
    public static BufferedImage dirt;
    public static BufferedImage grass;
    public static BufferedImage stone;
    public static BufferedImage tree;

    /**
     * Its going to load everything in our game, and make it once
     * It's loaded a test sheet, just to see if it's working..When we decide what will be the
     * theme of the background and etc. will change it.
     */
    public static void initialize() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test_sheet.png"));

        player = sheet.crop(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        dirt = sheet.crop(IMAGE_WIDTH, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        grass = sheet.crop(IMAGE_WIDTH * 2, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        stone = sheet.crop(IMAGE_WIDTH * 3, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        tree = sheet.crop(0, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
}
