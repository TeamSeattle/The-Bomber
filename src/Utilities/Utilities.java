/* ===================
 *        INFO
 * ===================
 * In this class we can put methods and other
 * stuff that we will need during the game development
 * For example if we need a number generator or something
 * of this kind we can put it here.
 */

package Utilities;

import java.awt.*;
import  java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Utilities {

    /**
     * This method will scaleImage a BufferedImage object
     * @param image -> The image you want to be scaleImage
     * @param xScale -> In double how much on the X axes
     * @param yScale -> In double how much on the Y axes
     * @return -> Returns the scaled image
     */
    public static BufferedImage scaleImage(BufferedImage image, double xScale, double yScale) {

        AffineTransform at = new AffineTransform();
        at.scale(xScale,yScale);
        BufferedImage after = new BufferedImage((int)(image.getWidth() * xScale),(int)(image.getHeight() * yScale),BufferedImage.TYPE_4BYTE_ABGR);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);

        return scaleOp.filter(image,after);
    }

    /**
     * This method will flipImage the image horizontally
     * @param image -> The image you want to be flipped
     * @return -> Returns the flipped image
     */
    public static BufferedImage flipImage(BufferedImage image){

        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);

        tx = AffineTransform.getScaleInstance(-1, -1);
        tx.translate(-image.getWidth(null), -image.getHeight(null));
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);

        return image;
    }

    /**
     * This method will give a random int in some range
     * @param min -> From number X
     * @param max -> To number Y
     * @return -> random int
     */
    public static int getRandom(int min,int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * This method will check if the two bounding boxes intersect
     * in some way
     * @param one -> Always Player Bounding Box
     * @param two -> Other Bounding box
     * @return -> True / False
     */
    public static boolean isInImpact(Rectangle one, Rectangle two){
        return one.intersects(two);
    }

    /**
     * This method will pause the game for X amount of seconds
     * @param seconds -> How many seconds
     */
    public static void sleep(double seconds){
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("");
        }
    }
}
