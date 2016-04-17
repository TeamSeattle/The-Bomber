package Entities.Enemies;

import Main.Engine;
import States.GameState;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class EnemyController {

    private LinkedList<Enemy_level_1> e =  new LinkedList<>();

    Random random = new Random();
    private Enemy_level_1 tempEnemy;

    private Engine engine;

    private GameState gameState;

    public EnemyController(Engine engine){
        this.engine = engine;
    }

    public EnemyController(GameState gameState) {
        this.gameState = gameState;
    }

    public void createEnemies(float enemyCount){
        for (int i=0; i < enemyCount; i++){
            addObject(new Enemy_level_1(random.nextInt(696),-200, engine));
            addEnemies(new Enemy_level_1(random.nextInt(696),-200, engine));
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



    public void addObject (Enemy_level_1 block){
        e.add(block);
    }
    public void removeObject(Enemy_level_1 block){

    }
    public void addEnemies (Enemy_level_1 block){
        e.add(block);
    }
    public void removeEnemies (Enemy_level_1 block){
        e.remove(block);
    }

}