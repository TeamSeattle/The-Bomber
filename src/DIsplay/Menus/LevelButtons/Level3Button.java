package DIsplay.Menus.LevelButtons;

import Graphics.Assets;
import Input.MouseManager;
import States.AllStates.GameState;

import java.awt.*;

public class Level3Button {

    static boolean isSelected = false;
    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670) &&
                time > 20) {
            System.out.println("CURRENT LEVEL : Level_3");
            time = 0;

            GameState.level = "level_3";
            isSelected = true;
            Level1Button.isSelected = false;
            Level2Button.isSelected = false;
            Level4Button.isSelected = false;
        }
        time++;
    }

    /**
     * Renders the start new game button for the menu
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if (isSelected){
            graphics.drawImage(Assets.level_3_selected, 347, 600, null);
        } else {
            if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                    (MouseManager.getY > 600 && MouseManager.getY < 670)) {
                graphics.drawImage(Assets.level_3_hover, 347, 600, null);
            } else {
                graphics.drawImage(Assets.level_3, 347, 600, null);
            }
        }
    }

    public static void resetTime(){
        time = 0;
    }
}
