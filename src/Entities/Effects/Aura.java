package Entities.Effects;

import Graphics.Assets;

import java.awt.*;

public class Aura {

    private boolean isActive;
    private int time = 540;

    /**
     * Constructor
     */
    public Aura(boolean isActive) {
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

    public void render(Graphics graphics , int x, int y){
        graphics.drawImage(Assets.armor,x + 32,y + 32,null);

        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(time / 60 + 1 + "",x + 55,y + 32);
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
