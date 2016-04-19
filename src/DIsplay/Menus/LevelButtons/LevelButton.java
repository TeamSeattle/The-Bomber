package DIsplay.Menus.LevelButtons;

import DIsplay.Menus.ExitButtons.ExitButton;
import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;
import States.StateManager;

import java.awt.*;

public class LevelButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670) &&
                time > 20) {
            StateManager.setCurrentState(Engine.levelPickerState);
            System.out.println("SWITCHED STATE : MenuState");
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
            graphics.drawImage(Assets.level_button_hover, 347, 600, null);
        } else {
            graphics.drawImage(Assets.level_button, 347, 600, null);
        }
    }

    public static void resetTime(){
        time = 0;
    }
}
