package DIsplay.Menus.OtherButtons;

import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;
import States.StateManager;

import java.awt.*;

public class NoButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 700 && MouseManager.getY < 770) &&
                time > 20) {

            // Which state to return
            switch (StateManager.getPreviousState().name) {
                case "Menu_State":
                    StateManager.setCurrentState(Engine.menuState);
                    break;
                case "Pause_State":
                    StateManager.setCurrentState(Engine.pauseState);
                    break;
                case "Dead_State":
                    StateManager.setCurrentState(Engine.deadState);
                    break;
            }

            InfoButton.resetTime();

            time = 0;
        }
        time++;
    }

    /**
     * Renders the exit button for the menus
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 700 && MouseManager.getY < 770)) {
            graphics.drawImage(Assets.no_button_hover, 347, 700, null);
        } else {
            graphics.drawImage(Assets.no_button, 347, 700, null);
        }
    }

    public static void resetTime() {
        time = 0;
    }
}
