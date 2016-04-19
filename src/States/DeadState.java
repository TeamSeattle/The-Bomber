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

import DIsplay.Menus.ExitButtons.ExitButton;
import DIsplay.Menus.OtherButtons.StartNewGameButton;
import DIsplay.Menus.ToMainMenuButtons.ToMainMenuButtonDead;
import Entities.Creature.Player;
import Main.Engine;
import Graphics.Assets;

import java.awt.*;

public class DeadState extends State{

    private Engine engine;
    /**
     * Constructor
     */
    public DeadState(Engine engine){
        super(engine);
        name = "Dead";
        this.engine = engine;
    }

    @Override
    public void tick() {
        ToMainMenuButtonDead.tick();
        StartNewGameButton.tick();
        ExitButton.tick();
    }

    @Override
    public void render(Graphics graphics) {
        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(" YOU ARE DEAD ",325,360);
        graphics.drawString("SCORE:",390,520);

        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 40));

        // Draw point in the center
        if (Player.POINTS < 10){
            graphics.drawString(Player.POINTS + "",440,570);
        } else if (Player.POINTS >= 10 && Player.POINTS < 100){
            graphics.drawString(Player.POINTS + "",426,570);
        } else if (Player.POINTS >= 100 && Player.POINTS < 1000){
            graphics.drawString(Player.POINTS + "",416,570);
        } else {
            graphics.drawString(Player.POINTS + "",406,570);
        }

        ToMainMenuButtonDead.render(graphics);
        StartNewGameButton.render(graphics);
        ExitButton.render(graphics);
    }
}
