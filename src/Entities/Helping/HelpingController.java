package Entities.Helping;

import Main.Engine;
import States.GameState;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class HelpingController {

    private LinkedList<Helping_Health> healthObjects = new LinkedList<>();

    Random random = new Random();
    private Helping_Health tempHealthObject;

    private GameState gameState;

    public HelpingController(GameState gameState) {
        this.gameState = gameState;
    }

    public void createHealthObject(float healthObjectCount) {
        for (int i = 0; i < healthObjectCount; i++) {
            addHealthObject(new Helping_Health(random.nextInt(896), -200));
        }

    }

    public void tick() {
        for (int i = 0; i < healthObjects.size(); i++) {
            tempHealthObject = healthObjects.get(i);

            if (tempHealthObject.getY() > 660) {
                tempHealthObject.setY(-200);
                tempHealthObject.setX(random.nextInt(696));
                tempHealthObject.setSpeed(random.nextInt(5) + 1);
            }
            tempHealthObject.tick();
        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < healthObjects.size(); i++) {
            tempHealthObject = healthObjects.get(i);
            tempHealthObject.render(graphics);
        }
    }

    public void addHealthObject(Helping_Health block) {
        healthObjects.add(block);
    }

    public void removeHealthObject(Helping_Health block) {
        healthObjects.remove(block);
    }

}
