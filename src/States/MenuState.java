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
import Main.Engine;

import java.awt.*;

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
        a++;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("The Bomber", 420, 300);
        graphics.drawString("(Work In Progress)", 405, 320);

        graphics.drawString("PRESS ESCAPE TO RUN THE GAME", 350, 500);
        graphics.drawString("AND TO GET BACK IN THE MENU", 360, 520);
    }
}
