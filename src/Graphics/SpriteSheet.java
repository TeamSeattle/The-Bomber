package Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    /**
     * Constructor
     * It takes a buffered image with encoding of 64 bits
     */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    //We load the sprite sheet but we want to crop a part of it .
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
