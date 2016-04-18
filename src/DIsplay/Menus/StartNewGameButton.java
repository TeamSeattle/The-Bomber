package DIsplay.Menus;

import Input.MouseManager;

import java.awt.*;

import Graphics.Assets;
import Main.Engine;
import States.GameState;
import States.StateManager;

public class StartNewGameButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 400 && MouseManager.getY < 470) &&
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
                (MouseManager.getY > 400 && MouseManager.getY < 470)) {
            graphics.drawImage(Assets.start_menu_button_hover, 347, 400, null);
        } else {
            graphics.drawImage(Assets.start_menu_button, 347, 400, null);
        }
    }
}
