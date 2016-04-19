package Effects;

import Graphics.Assets;

import java.awt.*;

/**
 * Created by Ivailo on 17-Apr-16.
 */
public class Effect_Speed {

    private static boolean isActive;
    private int time = 540;

    /**
     * Constructor
     */
    public Effect_Speed(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * This method will be called in the tick method of the player
     */
    public void tick() {
        time--;

        if (time == 0) {
            isActive = false;
            time = 540;
        }
    }

    /**
     * This method will be called in the render method of the player
     */
    public void render(Graphics graphics , int x, int y){
        // DRAW PLAYER
            graphics.drawImage(Assets.speed_icon,x + 110,y + 48,null);
    }

    /**
     * Sets the value of the isActive variable
     * @param state -> Give the value to be set
     */
    public static void setIsActive(boolean state){
        isActive = state;
    }

    /**
     * Returns in what state is the isActive
     * @return -> returns boolean
     */
    public boolean getIsActive(){
        return isActive;
    }

    public int getTimeLeft(){
        return time / 60 + 1;
    }
}
