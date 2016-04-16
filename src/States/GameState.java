/* ===================
 *        INFO
 * ==================
 *
 * The game state is when the person is playing
 * It will be active until the player dies
 * Then we can switch to the dead state of the game
 *
 */

package States;

import DIsplay.Display;
import Effects.ControllerHealth;
import Effects.HealthObject;
import Entities.Creature.Controller;
import Entities.Creature.Enemies;
import Entities.Creature.Player;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;

import java.awt.*;

public class GameState extends State {

    private float enemyCount = 5;
    private float healthObjectCount = 3;
    //Create a player with name "player",for the test :)
    private Player player;
    private Controller controller;
    private Enemies enemy;
    private HealthObject healthObject;
    private ControllerHealth controllerHealth;


   /**
     * Constructor
     */
    public GameState(Engine engine) {
        super(engine);
        name = "Game";

        // Create a player player
        player = new Player(engine, Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);
        enemy = new Enemies(engine, Assets.IMAGE_WIDTH*6, Assets.IMAGE_HEIGHT*9 +33);
        healthObject = new HealthObject(engine, Assets.IMAGE_HEIGHT*6, Assets.IMAGE_HEIGHT*9 +33);
        controller = new Controller(this);
        controller.createEnemies(enemyCount);
        controllerHealth = new ControllerHealth(this);
        controllerHealth.createHealthObject(healthObjectCount);
    }

    int a = 0;

    @Override
    public void tick() {

        if (KeyManager.escape && a > 20) {
            StateManager.setCurrentState(Engine.menuState);
            System.out.println("SWITCHED STATE : MenuState");
            a = 0;
        }
        player.tick();
        enemy.tick();
        controller.tick();
        healthObject.tick();
        controllerHealth.tick();
        a++;
    }

    int position = 0;

    @Override
    public void render(Graphics graphics) {

        // TEST CODE
        graphics.drawImage(Assets.set2_background, 0, 0, Display.WINDOW_WIDTH, Assets.set2_background.getHeight() + 300, null);
        graphics.drawImage(Assets.set2_hills, 0, 0, Display.WINDOW_WIDTH, Assets.set2_background.getHeight() + 300, null);
        graphics.drawImage(Assets.set2_tiles, 0, 0, Display.WINDOW_WIDTH, Assets.set2_background.getHeight() + 200, null);

        // WORLD TEST
        graphics.drawImage(Assets.blue_land_left, 0, Assets.IMAGE_HEIGHT * 11, null);
        for (int i = 1; i < 13; i++) {
            graphics.drawImage(Assets.blue_land_middle, Assets.IMAGE_WIDTH * i, Assets.IMAGE_HEIGHT * 11, null);
        }
        graphics.drawImage(Assets.blue_land_right, Assets.IMAGE_WIDTH * 13, Assets.IMAGE_HEIGHT * 11, null);

        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < 14; i++) {
                graphics.drawImage(Assets.blue_solid, Assets.IMAGE_WIDTH * i, Assets.IMAGE_HEIGHT * (12 + x), null);
            }
        }

        graphics.drawImage(Assets.blue_pattern_2, Assets.IMAGE_WIDTH, Assets.IMAGE_HEIGHT * 13, null);
        graphics.drawImage(Assets.blue_pattern_2, Assets.IMAGE_WIDTH * 3, Assets.IMAGE_HEIGHT * 14, null);

        graphics.drawImage(Assets.blue_pattern_2, Assets.IMAGE_WIDTH * 12, Assets.IMAGE_HEIGHT * 13, null);
        graphics.drawImage(Assets.blue_pattern_2, Assets.IMAGE_WIDTH * 7, Assets.IMAGE_HEIGHT * 12, null);

        graphics.drawImage(Assets.blue_pattern_1, Assets.IMAGE_WIDTH, Assets.IMAGE_HEIGHT * 13, null);
        graphics.drawImage(Assets.blue_pattern_1, Assets.IMAGE_WIDTH * 5, Assets.IMAGE_HEIGHT * 14, null);

        graphics.drawImage(Assets.blue_land_left, Assets.IMAGE_WIDTH * 9, Assets.IMAGE_HEIGHT * 13, null);
        graphics.drawImage(Assets.blue_land_middle, Assets.IMAGE_WIDTH * 10, Assets.IMAGE_HEIGHT * 13, null);
        graphics.drawImage(Assets.blue_land_right, Assets.IMAGE_WIDTH * 11, Assets.IMAGE_HEIGHT * 13, null);

        if (position < -128) {
            position = 0;
        }

        for (int i = 0; i < 16; i++) {
            graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * i + position, Assets.IMAGE_HEIGHT * 14, null);
        }
        position--;

        // PLANTS
        graphics.drawImage(Assets.plat_gray_6, Assets.IMAGE_WIDTH, Assets.IMAGE_HEIGHT * 10, null);
        graphics.drawImage(Assets.plat_gray_4, Assets.IMAGE_WIDTH * 5, Assets.IMAGE_HEIGHT * 10, null);
        graphics.drawImage(Assets.plat_gray_2, Assets.IMAGE_WIDTH * 8, Assets.IMAGE_HEIGHT * 10, null);
        graphics.drawImage(Assets.plat_gray_1, Assets.IMAGE_WIDTH * 3, Assets.IMAGE_HEIGHT * 10, null);
        graphics.drawImage(Assets.plat_gray_3, Assets.IMAGE_WIDTH * 13, Assets.IMAGE_HEIGHT * 10, null);
        graphics.drawImage(Assets.plat_gray_5, Assets.IMAGE_WIDTH * 10, Assets.IMAGE_HEIGHT * 10, null);

        graphics.drawImage(Assets.plat_gray_6, Assets.IMAGE_WIDTH * 10, Assets.IMAGE_HEIGHT * 12, null);

        //Test the player drawing.
        player.render(graphics);
        enemy.render(graphics);
        controller.render(graphics);
        healthObject.render(graphics);
        controllerHealth.render(graphics);
    }

        public float getEnemiesCount(){
            return enemyCount;
        }
        public  void setEnemiesCount(float enemyCount){
            this.enemyCount = enemyCount;
        }

    }
