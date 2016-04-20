package DIsplay.Menus.LevelButtons;

import Graphics.Assets;
import Input.MouseManager;
import States.AllStates.GameState;

import java.awt.*;

public class Level1Button {

    static boolean isSelected = true;
    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 400 && MouseManager.getY < 470) &&
                time > 20) {
            System.out.println("CURRENT LEVEL : Level_1");
            time = 0;

            GameState.level = "level_1";
            isSelected = true;
            Level2Button.isSelected = false;
            Level3Button.isSelected = false;
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
            graphics.drawImage(Assets.level_1_selected, 347, 400, null);
        } else {
            if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                    (MouseManager.getY > 400 && MouseManager.getY < 470)) {
                graphics.drawImage(Assets.level_1_hover, 347, 400, null);
            } else {
                graphics.drawImage(Assets.level_1, 347, 400, null);
            }
        }

    }
}
