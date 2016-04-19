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

import DIsplay.Menus.ExitButtons.ExitButtonMainMenu;
import DIsplay.Menus.LevelButtons.LevelButton;
import DIsplay.Menus.OtherButtons.InfoButton;
import DIsplay.Menus.OtherButtons.StartNewGameButton;
import DIsplay.Menus.OtherButtons.VolumeButton;
import Main.Engine;
import Graphics.Assets;

import java.awt.*;

public class MenuState extends State {

    private Engine engine;

    /**
     * Constructor
     */
    public MenuState(Engine engine) {
        super(engine);
        name = "MenusRender";
    }

    @Override
    public void tick() {
        // Tick all the buttons
        StartNewGameButton.tick();
        VolumeButton.tick();
        LevelButton.tick();
        InfoButton.tick();
        ExitButtonMainMenu.tick();
    }

    @Override
    public void render(Graphics graphics) {

        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString("(Main Menu)",355,350);

        // Render all the buttons
        StartNewGameButton.render(graphics);
        VolumeButton.render(graphics);
        LevelButton.render(graphics);
        InfoButton.render(graphics);
        ExitButtonMainMenu.render(graphics);
    }


}
