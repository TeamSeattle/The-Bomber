package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//This class is for load a buffered picture

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            //If we don't load an image , don't load the game.
            System.exit(1);
        }
        return null;
    }
}
