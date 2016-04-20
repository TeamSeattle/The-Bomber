package States.AllStates;

import DIsplay.Menus.OtherButtons.NoButton;
import DIsplay.Menus.OtherButtons.YesButton;
import Graphics.Assets;
import Main.Engine;
import States.State;

import java.awt.*;

public class ExitPromptState extends State {

    public ExitPromptState(Engine engine) {
        super(engine);
        name = "Stats_State";
    }

    @Override
    public void tick() {
        YesButton.tick();
        NoButton.tick();
    }

    @Override
    public void render(Graphics graphics) {
        // Background
        graphics.drawImage(Assets.exit_background, 0, 0, null);
        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(" Statistics ",360,360);
        // Buttons
        YesButton.render(graphics);
        NoButton.render(graphics);
    }
}
