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

import java.awt.*;

public class MenuState extends State {

    /**
     * Constructor
     */
    public MenuState() {
        name = "Menus";
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("MENU RUNNING", 100, 100);
    }
}
