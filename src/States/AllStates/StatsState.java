package States.AllStates;

import DIsplay.Menus.OtherButtons.BackButton;
import Graphics.Assets;
import Main.Engine;
import States.State;
import Statistics.Statistics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class StatsState extends State {

    public StatsState(Engine engine) {
        super(engine);
        name = "Stats_State";
    }

    @Override
    public void tick() {
        BackButton.tick();
    }

    @Override
    public void render(Graphics graphics) {

        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);
        // Render text
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 32));
        graphics.drawString(" Statistics ",360,360);

        // Render Stats
        ArrayList<String> score = Statistics.getScores();
        Collections.reverse(score);
        int yPosition = 420;
        int place = 1;
        for (String individualScore : score) {
            graphics.drawString(individualScore,250,yPosition);
            yPosition += 40;
            place++;
        }

        BackButton.render(graphics);
    }
}
