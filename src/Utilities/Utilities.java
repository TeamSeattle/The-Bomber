/* ===================
 *        INFO
 * ===================
 * In this class we can put methods and other
 * stuff that we will need during the game development
 * For example if we need a number generator or something
 * of this kind we can put it here.
 */

package Utilities;

import  java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Utilities {

    /**
     * This method will scale a BufferedImage object
     * @param image -> The image you want to be scale
     * @param xScale -> In double how much on the X axes
     * @param yScale -> In double how much on the Y axes
     * @return -> Returns the scaled image
     */
    public static BufferedImage scale(BufferedImage image,double xScale, double yScale) {
        AffineTransform at = new AffineTransform();
        at.scale(xScale,yScale);
        BufferedImage after = new BufferedImage((int)(image.getWidth() * xScale),(int)(image.getHeight() * yScale),BufferedImage.TYPE_4BYTE_ABGR);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        return scaleOp.filter(image,after);
    }
}
