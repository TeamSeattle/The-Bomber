package States.AllStates;

import DIsplay.Menus.OtherButtons.RestartGameButton;
import DIsplay.Menus.OtherButtons.ResumeButton;
import DIsplay.Menus.StatsButtons.StatsButton;
import DIsplay.Menus.ToMainMenuButtons.ToMainMenuButton;
import DIsplay.Menus.OtherButtons.VolumeButton;
import Input.KeyManager;
import Main.Engine;
import Graphics.Assets;
import States.State;
import States.StateManager;

import java.awt.*;

public class PauseState extends State {
    public PauseState(Engine engine) {
        super(engine);
        name = "Pause_State";
    }

    private static int time = 0;

    @Override
    public void tick() {
        // Escape functionality
        if (KeyManager.escape && time > 20) {
            StateManager.setCurrentState(Engine.gameState);
            System.out.println("SWITCHED STATE : GameState");
            time = 0;
        }

        // Tick all the buttons
        ResumeButton.tick();
        VolumeButton.tick();
        StatsButton.tick();
        RestartGameButton.tick();
        ToMainMenuButton.tick();

        // Update System value
        time++;
    }

    @Override
    public void render(Graphics graphics) {
        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(" Pause Menu ",345,360);

        // Render all the buttons
        ResumeButton.render(graphics);
        VolumeButton.render(graphics);
        StatsButton.render(graphics);
        RestartGameButton.render(graphics);
        ToMainMenuButton.render(graphics);
    }

    public static void resetTime(){
        time = 0;
    }
}
