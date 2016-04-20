package DIsplay.Menus.StatsButtons;

import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;
import States.StateManager;

import java.awt.*;

public class StatsButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 448 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570) &&
                time > 20) {
            System.out.println("Stats");
            StateManager.setCurrentState(Engine.statsState);
            time = 0;
        }
        time++;
    }

    /**
     * Renders the volume ON / OFF button for the menu
     *
     * @param graphics -> Required
     */
    public static void render(Graphics graphics) {
        if ((MouseManager.getX > 448 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570)) {
            graphics.drawImage(Assets.stats_button_hover, 448, 500, null);
        } else {
            graphics.drawImage(Assets.stats_button, 448, 500, null);
        }
    }
}
