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

import Entities.Helping.HelpingController;
import Entities.Helping.Helping_Health;
import Entities.Enemies.Enemy_level_1;
import Entities.Creature.Player;
import Entities.Enemies.EnemyController;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;
import Worlds.World;

import java.awt.*;

public class GameState extends State {

    private float enemyCount = 5;
    private float healthObjectCount = 3;
    //Create a player with name "player",for the test :)
    private Player player;
    private EnemyController enemyController;
    private World world;
    private Enemy_level_1 enemy;
    private Helping_Health healthObject;
    private HelpingController controllerHealth;


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
        world = new World("level_1");

        // Create a player
        player = new Player(Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);
        enemy = new Enemy_level_1(Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);
        healthObject = new Helping_Health(Assets.IMAGE_HEIGHT * 6, Assets.IMAGE_HEIGHT * 9 + 33);

        enemyController = new EnemyController(this);
        enemyController.createEnemies(enemyCount);

        controllerHealth = new HelpingController(this);
        controllerHealth.createHealthObject(healthObjectCount);
    }

    int a = 0;
    @Override
    public void tick() {

        if (KeyManager.escape && a > 20) {
            StateManager.setCurrentState(Engine.pauseState);
            System.out.println("SWITCHED STATE : PauseState");
            a = 0;
        }

        // WORLD + PLAYER
        world.tick();
        player.tick();

        // ENEMY
        enemy.tick();
        enemyController.tick();

        // BONUSES
        healthObject.tick();
        controllerHealth.tick();

        // System value
        a++;
    }

    @Override
    public void render(Graphics graphics) {
        //Test the player drawing.
        world.render(graphics);
        player.render(graphics);

        enemyController.render(graphics);
        controllerHealth.render(graphics);

        graphics.drawImage(Assets.settings_button,830,0,null);
    }


    public float getObjectCount() {
        return enemyCount;
    }

    public float getEnemiesCount() {
        return enemyCount;
    }

    public void setEnemiesCount(float enemyCount) {
        this.enemyCount = enemyCount;
    }

    public void setObjectCount(float enemyCount) {
        this.enemyCount = enemyCount;
    }

}
