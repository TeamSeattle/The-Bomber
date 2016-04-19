package Effects;

import Graphics.Assets;

import java.awt.*;

public class Effect_Aura {

    private boolean isActive;
    private int time = 540;

    /**
     * Constructor
     */
    public Effect_Aura(boolean isActive) {
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
        // DRAW ON PLAYER
        graphics.drawImage(Assets.aura_on_player,x + 32,y + 32,null);
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

    public int getTimeLeft(){
        return time / 60 + 1;
    }
}
