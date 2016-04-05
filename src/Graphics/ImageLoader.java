package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    /**
     * Whit this method we will load all the images for our game
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            System.out.println("Shit");
            e.printStackTrace();
            // If we don't load an image , don't load the game.
            System.exit(1);
        }
        return null;
    }
}
