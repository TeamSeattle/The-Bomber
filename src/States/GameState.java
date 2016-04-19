/* ===================
 *        INFO
 * ==================
 *
 * The game state is when the person is playing
 * It will be active until the player dies
 * Then we can switch to the dead state of the game
 *1
 */

package States;

import DIsplay.UI;
import Entities.Entity;
import Entities.Helping.BonusController;
import Entities.Creature.Player;
import Entities.Enemies.EnemyController;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;
import Worlds.World;

import java.awt.*;

public class GameState extends State {

    private float enemyCount = 25;
    private float powerUpsCount = 100;
    //Create time player with name "player",for the test :)
    private Player player;
    private EnemyController enemyController;
    private World world;
    private BonusController powerUpsController;
    private UI ui;

    // Level
    public static String level = "level_1";

    /**
     * Constructor
     */
    public GameState(Engine engine) {
        super(engine);
        name = "Game";

        initialize();
    }

    private void initialize(){

        // Create world
        world = new World(level);

        // Create time player
        player = new Player(Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 10 - 5);
        ui = new UI(this);

        // Initialize Enemies
        enemyController = new EnemyController(this);
        enemyController.createEnemies(enemyCount);

        // Initialize Power-ups
        powerUpsController = new BonusController(this);
        powerUpsController.createBonuses(powerUpsCount);
    }

    private int time = 0;

    @Override
    public void tick() {

        if (KeyManager.escape && time > 20) {
            StateManager.setCurrentState(Engine.pauseState);
            System.out.println("SWITCHED STATE : PauseState");
            time = 0;
            PauseState.resetTime();
        }

        if (KeyManager.boundsSwitch && time > 20){
            Entity.boundsToggle = !Entity.boundsToggle;
            System.out.println("BOUNDS : " + Entity.boundsToggle);
            time = 0;
        }

        // WORLD
        world.tick();
        // ENEMY
        enemyController.tick();
        // BONUSES
        powerUpsController.tick();
        // UI
        ui.tick();
        // PLAYER
        player.tick();

        // System value
        time++;
    }

    @Override
    public void render(Graphics graphics) {
        // WORLD
        world.render(graphics);
        // ENEMY
        enemyController.render(graphics);
        // BONUSES
        powerUpsController.render(graphics);
        // UI
        ui.render(graphics);
        // PLAYER
        player.render(graphics);
    }

    public Player getPlayer(){
        return player;
    }

}
