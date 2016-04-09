/* ===================
 *        INFO
 * ==================
 *
 * We switch to the dead state when the player dies
 * From here you will be able to see some statistics
 * and be able to switch to menu state or straight to
 * the game state (from the beginning)
 *
 */

package States;

import Main.Engine;

import java.awt.*;

public class DeadState extends State{

    /**
     * Constructor
     */
    public DeadState(Engine engine){
        super(engine);
        name = "Dead";
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("YOU ARE DEAD",100,100);
    }
}
