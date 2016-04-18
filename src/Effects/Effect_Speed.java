package Effects;

import java.awt.*;
import Graphics.Assets;

/**
 * Created by Ivailo on 17-Apr-16.
 */
public class Effect_Speed {

    private boolean isActive;
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
        graphics.drawImage(Assets.speed,x + 32,y + 32,null);

        // DRAW CORNER
        graphics.setColor(Color.white);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(time / 60 + 1 + "",x + 85,y + 35);
    }

    /**
     * Sets the value of the isActive variable
     * @param state -> Give the value to be set
     */
    public void setIsActive(boolean state){
        this.isActive = state;
    }

    /**
     * Returns in what state is the isActive
     * @return -> returns boolean
     */
    public boolean getIsActive(){
        return isActive;
    }
}
