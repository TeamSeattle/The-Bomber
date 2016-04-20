package DIsplay.Menus.LevelButtons;

import Graphics.Assets;
import Input.MouseManager;
import States.AllStates.GameState;

import java.awt.*;

public class Level4Button {

    public static boolean isSelected = false;
    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 700 && MouseManager.getY < 770) &&
                time > 20) {
            System.out.println("CURRENT LEVEL : Level_4");
            time = 0;

            GameState.level = "level_4";
            isSelected = true;
            Level1Button.isSelected = false;
            Level2Button.isSelected = false;
            Level3Button.isSelected = false;
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
            graphics.drawImage(Assets.level_4_selected, 347, 700, null);
        } else {
            if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                    (MouseManager.getY > 700 && MouseManager.getY < 770)) {
                graphics.drawImage(Assets.level_4_hover, 347, 700, null);
            } else {
                graphics.drawImage(Assets.level_4, 347, 700, null);
            }
        }
    }
}
