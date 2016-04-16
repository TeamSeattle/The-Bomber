package Effects;

import Main.Engine;
import States.GameState;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class ControllerHealth {

    //    private LinkedList<Effects> effects = new LinkedList<Effects>();
    private LinkedList<HealthObject> healthObjects =  new LinkedList<HealthObject>();


    Random random = new Random();
    private HealthObject tempHealthObject;
//    private Effects tempEffects;

    private Engine engine;

    private GameState gameState;

    public ControllerHealth(Engine engine){
        this.engine = engine;
    }

    public ControllerHealth(GameState gameState) {
        this.gameState = gameState;
    }

//    public void createEffects(float effectsCount){
//        for (int j=0; j < effectsCount; j++){
//            addEffects(new Effects(random.nextInt(496), -100, engine));
//        }
//    }

    public void createHealthObject (float healthObjectCount){
        for (int i=0; i < healthObjectCount; i++){
            addHealthObject(new HealthObject(random.nextInt(696), -200, engine));
        }

    }

    public void tick(){
//        for (int j=0; j < effects.size(); j++){
//            tempEffects = effects.get(j);
//
//            if (tempEffects.getY()> 660){
//                tempEffects.setY(-100);
//                tempEffects.setX(random.nextInt(496));
//                tempEffects.setSpeed(random.nextInt(2) + 1);
//            }
//        }

        for (int i = 0; i <healthObjects.size(); i++){
            tempHealthObject = healthObjects.get(i);

            if (tempHealthObject.getY() > 660){
                tempHealthObject.setY(-200);
                tempHealthObject.setX(random.nextInt(696));
                tempHealthObject.setSpeed(random.nextInt(5) + 1);
            }
            tempHealthObject.tick();
        }
    }
    public void render (Graphics graphics){

//        for (int j=0; j < effects.size(); j++){
//            tempEffects = effects.get(j);
//            tempEffects.render(graphics);
//        }

        for (int i = 0; i < healthObjects.size(); i++){
            tempHealthObject = healthObjects.get(i);
            tempHealthObject.render(graphics);
        }
    }

//    public void addEffects (Effects block){
//        effects.add(block);
//    }
//    public void removeEffects(Effects block){
//        effects.remove(block);
//    }



    public void addHealthObject (HealthObject block){
        healthObjects.add(block);
    }
    public void removeHealthObject (HealthObject block){
        healthObjects.remove(block);
    }

}
