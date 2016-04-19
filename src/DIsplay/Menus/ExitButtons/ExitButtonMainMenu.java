package DIsplay.Menus.ExitButtons;

import Graphics.Assets;
import Input.MouseManager;

import java.awt.*;

public class ExitButtonMainMenu {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 800 && MouseManager.getY < 870) &&
                time > 20) {
            System.exit(0);
            time = 0;
        }
        time++;
    }

    /**
     * Renders the exit button for the menu
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 800 && MouseManager.getY < 870)) {
            graphics.drawImage(Assets.close_menu_button_hover, 347, 800, null);
        } else {
            graphics.drawImage(Assets.close_menu_button, 347, 800, null);
        }
    }

    public static void resetTime() {
        time = 0;
    }
}
