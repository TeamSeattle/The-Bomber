package Entities.Creature;

import Main.Engine;
import States.GameState;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<Object> e =  new LinkedList<Object>();


    Random random = new Random();
    private Object tempEnemy;

    private Engine engine;

    private GameState gameState;

    public Controller(Engine engine){
        this.engine = engine;
    }

    public Controller(GameState gameState) {
        this.gameState = gameState;
    }

    public void createEnemies(float enemyCount){
        for (int i=0; i < enemyCount; i++){
            addObject(new Object(random.nextInt(696),-200, engine));
        }

    }

    public void tick(){

        for (int i = 0; i < e.size(); i++){
            tempEnemy = e.get(i);

            if (tempEnemy.getY() > 660){
                tempEnemy.setY(-200);
                tempEnemy.setX(random.nextInt(696));
                tempEnemy.setSpeed(random.nextInt(5) + 1);
            }
            tempEnemy.tick();
        }
    }
    public void render (Graphics graphics){

        for (int i = 0; i < e.size(); i++){
            tempEnemy = e.get(i);
            tempEnemy.render(graphics);
        }
    }



    public void addObject (Object block){
        e.add(block);
    }
    public void removeObject(Object block){
        e.remove(block);
    }

}