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
    private EnemyController controller;
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

        // Create world
        world = new World("level_1");

        // Create a player player
        player = new Player(engine, Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);

        enemy = new Enemy_level_1(engine, Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);

        enemy = new Enemy_level_1(engine, Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);
        healthObject = new Helping_Health(engine, Assets.IMAGE_HEIGHT * 6, Assets.IMAGE_HEIGHT * 9 + 33);

        controller = new EnemyController(this);
        controller.createEnemies(enemyCount);
        controllerHealth = new HelpingController(this);
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

        world.tick();
        enemy.tick();
        player.tick();
        controller.tick();
        healthObject.tick();
        controllerHealth.tick();
        a++;
    }

    @Override
    public void render(Graphics graphics) {
        //Test the player drawing.
        world.render(graphics);
        player.render(graphics);
        enemy.render(graphics);
        controller.render(graphics);
        healthObject.render(graphics);
        controllerHealth.render(graphics);
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
