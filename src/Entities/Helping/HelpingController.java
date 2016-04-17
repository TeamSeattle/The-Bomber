package Entities.Helping;

import Main.Engine;
import States.GameState;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class HelpingController {

    // private LinkedList<Helping> effects = new LinkedList<Helping>();
    private LinkedList<Helping_Health> healthObjects = new LinkedList<Helping_Health>();

    Random random = new Random();
    private Helping_Health tempHealthObject;
    // private Helping tempEffects;

    private Engine engine;

    private GameState gameState;

    public HelpingController(Engine engine) {
        this.engine = engine;
    }

    public HelpingController(GameState gameState) {
        this.gameState = gameState;
    }

    // public void createEffects(float effectsCount){
    //     for (int j=0; j < effectsCount; j++){
    //         addEffects(new Helping(random.nextInt(496), -100, engine));
    //     }
    // }

    public void createHealthObject(float healthObjectCount) {
        for (int i = 0; i < healthObjectCount; i++) {
            addHealthObject(new Helping_Health(random.nextInt(696), -200, engine));
        }

    }

    public void tick() {
        // for (int j=0; j < effects.size(); j++){
        //     tempEffects = effects.get(j);
        //
        //     if (tempEffects.getY()> 660){
        //         tempEffects.setY(-100);
        //         tempEffects.setX(random.nextInt(496));
        //         tempEffects.setSpeed(random.nextInt(2) + 1);
        //     }
        // }

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

        // for (int j=0; j < effects.size(); j++){
        //     tempEffects = effects.get(j);
        //     tempEffects.render(graphics);
        // }

        for (int i = 0; i < healthObjects.size(); i++) {
            tempHealthObject = healthObjects.get(i);
            tempHealthObject.render(graphics);
        }
    }

    // public void addEffects (Helping block){
    //     effects.add(block);
    // }
    // public void removeEffects(Helping block){
    //     effects.remove(block);
    // }


    public void addHealthObject(Helping_Health block) {
        healthObjects.add(block);
    }

    public void removeHealthObject(Helping_Health block) {
        healthObjects.remove(block);
    }

}
