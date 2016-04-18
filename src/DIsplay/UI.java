package DIsplay;

import Graphics.Assets;
import States.GameState;

import java.awt.*;

public class UI {

    private GameState gameState;

    public UI(GameState state){
        this.gameState = state;
    }

    public void tick(){

    }

    public void render(Graphics graphics){
        for (int i = 0; i < 3; i++) {
            graphics.drawImage(Assets.darken,64 * i,0,null);
            // graphics.drawImage(Assets.darken,64 * i,32,null);
        }
        renderHealth(graphics);
        renderArmour(graphics);
    }

    // PLAYER RENDER METHODS
    public void renderHealth(Graphics graphics){
        int getPosition = 0;
        for (int i = 0; i < gameState.getPlayer().HEALTH; i++) {
            graphics.drawImage(Assets.health,32 * i + 15,10,null);
            getPosition = i + 1;
        }
        for (int i = getPosition; i < gameState.getPlayer().MAX_HEALTH - gameState.getPlayer().HEALTH + getPosition; i++) {
            graphics.drawImage(Assets.health_empty,32 * i + 15,10,null);
        }
    }

    public void renderArmour(Graphics graphics){
        int getPosition = 0;
        for (int i = 0; i < gameState.getPlayer().ARMOUR; i++) {
            graphics.drawImage(Assets.armor,32 * i + 15,52,null);
            getPosition = i + 1;
        }
        for (int i = getPosition; i < gameState.getPlayer().MAX_ARMOUR - gameState.getPlayer().ARMOUR + getPosition; i++) {
            graphics.drawImage(Assets.armor_empty,32 * i + 15,52,null);
        }
    }

    public void rederPoints(Graphics graphics){

    }
}
