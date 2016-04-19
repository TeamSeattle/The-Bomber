package States;

import DIsplay.Menus.OtherButtons.BackButton;
import DIsplay.Menus.LevelButtons.Level1Button;
import DIsplay.Menus.LevelButtons.Level2Button;
import DIsplay.Menus.LevelButtons.Level3Button;
import DIsplay.Menus.LevelButtons.Level4Button;
import Main.Engine;
import Graphics.Assets;

import java.awt.*;

public class LevelPickerState extends State {

    public LevelPickerState(Engine engine) {
        super(engine);
    }

    @Override
    public void tick() {
        Level1Button.tick();
        Level2Button.tick();
        Level3Button.tick();
        Level4Button.tick();
        BackButton.tick();
    }

    @Override
    public void render(Graphics graphics) {

        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(" Level Selection ",315,360);

        Level1Button.render(graphics);
        Level2Button.render(graphics);
        Level3Button.render(graphics);
        Level4Button.render(graphics);
        BackButton.render(graphics);
    }
}
