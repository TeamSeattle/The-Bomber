package DIsplay.Menus;

import Graphics.Assets;
import Input.MouseManager;
import Main.Engine;

import java.awt.*;

public class VolumeButton {

    private static int time = 0;

    /**
     * Ticks every time when called
     */
    public static void tick() {
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570) &&
                time > 20) {
            Engine.volume = !Engine.volume;
            System.out.println("Volume: " + Engine.volume);
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
        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570)) {
            if (Engine.volume) {
                graphics.drawImage(Assets.volume_on_menu_button_hover, 347, 500, null);
            } else {
                graphics.drawImage(Assets.volume_off_menu_button_hover, 347, 500, null);
            }
        } else {
            if (Engine.volume) {
                graphics.drawImage(Assets.volume_on_menu_button, 347, 500, null);
            } else {
                graphics.drawImage(Assets.volume_off_menu_button, 347, 500, null);
            }
        }
    }
}
