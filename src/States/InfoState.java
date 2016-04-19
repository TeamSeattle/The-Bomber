package States;

import DIsplay.Menus.OtherButtons.BackButton;
import Main.Engine;
import Graphics.Assets;

import java.awt.*;

public class InfoState extends State {

    public InfoState(Engine engine) {
        super(engine);
    }

    @Override
    public void tick() {
        BackButton.tick();
    }

    @Override
    public void render(Graphics graphics) {

        // Background
        graphics.drawImage(Assets.info_background, 0, 0, null);

        BackButton.render(graphics);
    }
}
