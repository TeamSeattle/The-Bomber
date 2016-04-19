package DIsplay.Menus.ToMainMenuButtons;

import DIsplay.Menus.ExitButtons.ExitButton;
import DIsplay.Menus.LevelButtons.LevelButton;
import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;
import States.StateManager;

import java.awt.*;

public class ToMainMenuButtonDead {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670) &&
                time > 20) {
            StateManager.setCurrentState(Engine.menuState);
            System.out.println("SWITCHED STATE : MenuState");
            time = 0;
            ExitButton.resetTime();
            LevelButton.resetTime();
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
            graphics.drawImage(Assets.to_main_menu_hover, 347, 600, null);
        } else {
            graphics.drawImage(Assets.to_main_menu, 347, 600, null);
        }
    }
}
