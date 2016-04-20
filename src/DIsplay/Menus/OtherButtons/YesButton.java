package DIsplay.Menus.OtherButtons;

import DIsplay.Menus.ExitButtons.ExitButton;
import DIsplay.Menus.LevelButtons.Level3Button;
import Graphics.Assets;
import Input.MouseManager;

import java.awt.*;

public class YesButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670) &&
                time > 20) {
            System.exit(1);
            time = 0;
            Level3Button.resetTime();
            ExitButton.resetTime();
        }
        time++;
    }

    /**
     * Renders the to main menu button
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670)) {
            graphics.drawImage(Assets.yes_button_hover, 347, 600, null);
        } else {
            graphics.drawImage(Assets.yes_button, 347, 600, null);
        }
    }

    public static void resetTime(){
        time = 0;
    }
}
