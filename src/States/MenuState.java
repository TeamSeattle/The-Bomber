/* ===================
 *        INFO
 * ==================
 *
 * The menu state is where all the menus will be
 * It will be good to have a some kind of menu state
 * for the level selection menu where you will be
 * able to chose the different levels that are available
 *
 * Also from this state you will switch to the game state
 */

package States;

import Input.KeyManager;
import Input.MouseManager;
import Main.Engine;

import java.awt.*;

import Graphics.Assets;

public class MenuState extends State {

    private Engine engine;

    /**
     * Constructor
     */
    public MenuState(Engine engine) {
        super(engine);
        name = "Menus";
    }

    int a = 0;

    @Override
    public void tick() {

        if (KeyManager.escape && a > 20) {
            StateManager.setCurrentState(Engine.gameState);
            System.out.println("SWITCHED STATE : GameState");
            a = 0;
        }
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 200 && MouseManager.getY < 270)) {
            StateManager.setCurrentState(Engine.gameState);
            a = 0;
        }
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 300 && MouseManager.getY < 370)) {
            // NO SETTINGS MENU
        }
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570)) {
            System.exit(0);
        }

        a++;
    }

    @Override
    public void render(Graphics graphics) {

        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 200 && MouseManager.getY < 270)) {
            graphics.drawImage(Assets.start_menu_button_hover, 347, 200, null);
        } else {
            graphics.drawImage(Assets.start_menu_button, 347, 200, null);
        }

        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 300 && MouseManager.getY < 370)) {
            graphics.drawImage(Assets.settings_menu_button_hover, 347, 300, null);
        } else {
            graphics.drawImage(Assets.settings_menu_button, 347, 300, null);
        }

        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570)) {
            graphics.drawImage(Assets.close_menu_button_hover, 347, 500, null);
        } else {
            graphics.drawImage(Assets.close_menu_button, 347, 500, null);
        }

    }
}
