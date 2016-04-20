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
        ArrayList<String[]> score = Statistics.getScores();

        graphics.setColor(Color.WHITE);
        // Draw position
        int position = 1;
        int yPosition = 410;
        for (int i = 0; i < 10; i++) {
            graphics.drawString(String.format("%02d",position),250,yPosition);
            position++;
            yPosition += 40;
        }
        yPosition = 410;
        int count = 0;
        // Draw points
        for (String[] entry : score) {
            if (count < 10){
                String points = entry[0];
                graphics.drawString("|  " + points,300,yPosition);
                yPosition += 40;
            }
            count++;
        }
        yPosition = 410;

        count = 0;
        // Draw Names
        for (String[] entry : score) {
            if (count < 10){
                String name = entry[1];
                graphics.drawString("|  " + name,420,yPosition);
                yPosition += 40;
            }
            count++;
        }

        BackButton.render(graphics);
    }
}
