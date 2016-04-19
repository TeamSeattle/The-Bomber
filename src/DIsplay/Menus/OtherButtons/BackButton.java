package DIsplay.Menus.OtherButtons;

import DIsplay.Menus.ExitButtons.ExitButton;
import DIsplay.Menus.ExitButtons.ExitButtonMainMenu;
import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;
import States.StateManager;

import java.awt.*;

public class BackButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 800 && MouseManager.getY < 870) &&
                time > 20) {
            ExitButtonMainMenu.resetTime();
            StateManager.setCurrentState(Engine.menuState);
            System.out.println("SWITCHED STATE : MenuState");
            time = 0;
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
                (MouseManager.getY > 800 && MouseManager.getY < 870)) {
            graphics.drawImage(Assets.back_button_hover, 347, 800, null);
        } else {
            graphics.drawImage(Assets.back_button, 347, 800, null);
        }
    }
}
