package Entities.Enemies;

import States.AllStates.GameState;
import Utilities.Utilities;

import java.awt.*;
import java.util.LinkedList;

public class EnemyController {

    // DEAD LINE
    private static final int DEAD_LINE = 700;

    private LinkedList<Enemy_level_1> enemies_level_1 = new LinkedList<Enemy_level_1>();

    public static GameState gameState;

    /**
     * Constructor
     * @param gameState -> Needs to know in what state is the game
     */
    public EnemyController(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Create the enemies that we start with
     * @param enemyCount -> How many enemies
     */
    public void createEnemies(float enemyCount){
        for (int i=0; i < enemyCount; i++){
            // Values
            int xPosition = Utilities.getRandom(1,896);
            int yPosition = Utilities.getRandom(200,400);

            addEnemies(new Enemy_level_1(xPosition,yPosition * -1));
        }
    }

    /**
     * Every frame ticks all the enemies
     * Updates there values
     */
    public void tick(){
        tickEnemylevel1();
    }

    /**
     * Ticks the properties of enemy level 1
     */
    private void tickEnemylevel1(){
        for (Enemy_level_1 enemy_level_1 : enemies_level_1) {
            if (enemy_level_1.getY() > DEAD_LINE) {
                int xPosition = Utilities.getRandom(1,896);
                int yPosition = Utilities.getRandom(200,400);
                int speed = Utilities.getRandom(1,5);
                // Set values
                enemy_level_1.setY(yPosition * -1);
                enemy_level_1.setX(xPosition);
                enemy_level_1.setSpeed(speed);
                addPoint();
            }
            enemy_level_1.tick();
        }
    }

    /**
     * Draw all the enemies to the screen
     * @param graphics -> Required
     */
    public void render (Graphics graphics){
        for (Enemy_level_1 enemy : enemies_level_1) {
            enemy.render(graphics);
        }
    }

    /**
     * This method will add enemies to the cycle
     * @param block -> What enemy to add
     */
    public void addEnemies (Enemy_level_1 block){
        enemies_level_1.add(block);
    }

    /**
     * This method will remove an enemy from the cycle
     * @param block -> What enemy to remove
     */
    public void removeEnemies (Enemy_level_1 block){
        enemies_level_1.remove(block);
    }

    /**
     * Add points to the player
     */
    private void addPoint(){
        gameState.getPlayer().POINTS++;
    }

}