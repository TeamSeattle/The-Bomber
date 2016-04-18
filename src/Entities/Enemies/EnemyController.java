package Entities.Enemies;

import Main.Engine;
import States.GameState;
import Utilities.Utilities;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class EnemyController {

    private LinkedList<Enemy_level_1> e = new LinkedList<>();

    Random random = new Random();

    private Engine engine;
    private GameState gameState;

    public EnemyController(GameState gameState) {
        this.gameState = gameState;
    }

    public void createEnemies(float enemyCount){
        for (int i=0; i < enemyCount; i++){
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(200,400);
            addEnemies(new Enemy_level_1(xPosition,yPosition * -1));
        }
    }

    public void tick(){
        for (Enemy_level_1 enemy : e) {
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(200,400);
            int speed = Utilities.getRandom(1,5);

            if (enemy.getY() > 650) {
                // Set values
                enemy.setY(yPosition * -1);
                enemy.setX(xPosition);
                enemy.setSpeed(speed);
            }
            enemy.tick();
        }
    }

    public void render (Graphics graphics){

        for (Enemy_level_1 enemy : e) {
            enemy.render(graphics);
        }
    }

    public void addEnemies (Enemy_level_1 block){
        e.add(block);
    }
    public void removeEnemies (Enemy_level_1 block){
        e.remove(block);
    }

}