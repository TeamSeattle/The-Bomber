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

package States.AllStates;

import DIsplay.Menus.ExitButtons.ExitButtonMainMenu;
import DIsplay.Menus.LevelButtons.LevelButton;
import DIsplay.Menus.OtherButtons.InfoButton;
import DIsplay.Menus.OtherButtons.StartNewGameButton;
import DIsplay.Menus.StatsButtons.StatsButton;
import DIsplay.Menus.OtherButtons.VolumeButton;
import Main.Engine;
import Graphics.Assets;
import States.State;

import java.awt.*;

public class MenuState extends State {

    private Engine engine;

    /**
     * Constructor
     */
    public MenuState(Engine engine) {
        super(engine);
        name = "Menu_State";
    }

    @Override
    public void tick() {
        // Tick all the buttons
        StartNewGameButton.tick();
        VolumeButton.tick();
        LevelButton.tick();
        InfoButton.tick();
        StatsButton.tick();
        ExitButtonMainMenu.tick();
    }

    @Override
    public void render(Graphics graphics) {

        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(" Main Menu ",355,360);

        // Render all the buttons
        StartNewGameButton.render(graphics);
        VolumeButton.render(graphics);
        LevelButton.render(graphics);
        InfoButton.render(graphics);
        StatsButton.render(graphics);
        ExitButtonMainMenu.render(graphics);
    }


}
