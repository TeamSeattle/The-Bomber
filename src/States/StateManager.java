/* ===================
 *        INFO
 * ==================
 *
 * This is a basic state manager which will store
 * the current state that the game is running
 * With this class you can set and get the current state
 * so that it is easier to render and tick the correct one.
 *
 */

package States;

public class StateManager {

    private static State currentState = null;

    /**
     * Set the current class that the program is running
     */
    public static void setCurrentState(State stateToSet){
        currentState = stateToSet;
    }

    /**
     * Get the current class that the program is running
     */
    public static State getCurrentState(){
        return currentState;
    }
}
