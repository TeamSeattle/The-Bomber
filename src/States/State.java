/* ===================
 *        INFO
 * ==================
 *
 * With states we will manage in what
 * faze of our game we are.
 * For example when we are playing we are in GameState
 * When we are in the menus we are in menuState
 * And so on. . .
 * We can switch state mid game and for example
 * when our player dies we will switch the sate to dead
 *
 * ==================
 *
 * Every state has it's own tick and render method
 * That way we can program different logic for every state
 * And every state will render custom stuff to the screen
 *
 */

package States;

import Main.Engine;

import java.awt.*;

public abstract class State {

    // Properties
    // Name is only for debugging
    public String name;

    //Insert keyboard input
    protected Engine engine;
    public State(Engine engine){
        this.engine=engine;
    }

    // This are the methods that all the game states will must have
    public abstract void tick();
    public abstract void render(Graphics graphics);

}
