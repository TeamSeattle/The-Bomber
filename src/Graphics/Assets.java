package Graphics;

import java.awt.image.BufferedImage;

// In assets is any image, sound or peace of a music
public class Assets {

    // Width and height of the images
    private static final int IMAGE_WIDTH = 128;
    private static final int IMAGE_HEIGHT = 128;

    // Assets
    public static BufferedImage player;
    public static BufferedImage dirt;
    public static BufferedImage grass;
    public static BufferedImage stone;
    public static BufferedImage tree;

    /**
     * Its going to load everything in our game, and store in RAM
     */
    public static void initialize() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/assets.png"));

        player = sheet.crop(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        dirt = sheet.crop(IMAGE_WIDTH, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        grass = sheet.crop(IMAGE_WIDTH * 2, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        stone = sheet.crop(IMAGE_WIDTH * 3, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        tree = sheet.crop(IMAGE_WIDTH * 4, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
}
