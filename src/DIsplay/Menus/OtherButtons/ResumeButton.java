package DIsplay.Menus.OtherButtons;

import Input.MouseManager;

import java.awt.*;

import Graphics.Assets;
import Main.Engine;
import States.PauseState;
import States.StateManager;

public class ResumeButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 400 && MouseManager.getY < 470) &&
                time > 20) {
            StateManager.setCurrentState(Engine.gameState);
            System.out.println("SWITCHED STATE : GameState");
            time = 0;
            PauseState.resetTime();
        }
        time++;
    }

    /**
     * Renders the resume to game button
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 400 && MouseManager.getY < 470)) {
            graphics.drawImage(Assets.resume_menu_button_hover, 347, 400, null);
        } else {
            graphics.drawImage(Assets.resume_menu_button, 347, 400, null);
        }
    }
}
