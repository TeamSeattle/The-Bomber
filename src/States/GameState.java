/* ===================
 *        INFO
 * ==================
 *
 * THe game state is when the person is playing
 * It will be active until the player dies
 * Then we can switch to the dead state of the game
 *
 */

package States;

import java.awt.*;

public class GameState extends State {

    /**
     * Constructor
     */
    public GameState(){
        name = "Game";
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("GAME RUNNING",100,100);
    }
}
