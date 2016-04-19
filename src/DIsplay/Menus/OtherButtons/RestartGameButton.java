package DIsplay.Menus.OtherButtons;

import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;
import States.GameState;
import States.StateManager;

import java.awt.*;

public class RestartGameButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670) &&
                time > 20) {
            Engine.gameState = new GameState(Engine.getEngine());
            StateManager.setCurrentState(Engine.gameState);
            System.out.println("SWITCHED STATE : GameState");
            time = 0;
        }
        time++;
    }

    /**
     * Renders the start new game button for the menu
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 600 && MouseManager.getY < 670)) {
            graphics.drawImage(Assets.restart_button_hover, 347, 600, null);
        } else {
            graphics.drawImage(Assets.restart_button, 347, 600, null);
        }
    }
}
