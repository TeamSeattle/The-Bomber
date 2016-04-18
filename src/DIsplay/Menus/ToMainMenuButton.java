package DIsplay.Menus;

import Input.MouseManager;

import java.awt.*;

import Graphics.Assets;
import Main.Engine;
import States.StateManager;

public class ToMainMenuButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 700 && MouseManager.getY < 770) &&
                time > 20) {
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
                (MouseManager.getY > 700 && MouseManager.getY < 770)) {
            graphics.drawImage(Assets.to_main_menu_hover, 347, 700, null);
        } else {
            graphics.drawImage(Assets.to_main_menu, 347, 700, null);
        }
    }
}
