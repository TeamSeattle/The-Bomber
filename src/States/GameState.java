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
import Entities.Creature.Controller;
import Entities.Enemies.Enemy;
import Entities.Creature.Player;
import Graphics.Assets;
import Input.KeyManager;
import Main.Engine;
import Worlds.World;

import java.awt.*;

public class GameState extends State {

    private float enemyCount = 5;
    //Create a player with name "player",for the test :)
    private Player player;
    private Controller controller;
    private Enemy enemy;
    private World world;

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
        enemy = new Enemy(engine, Assets.IMAGE_WIDTH * 6, Assets.IMAGE_HEIGHT * 9 + 33);
        controller = new Controller(this);
        controller.createEnemies(enemyCount);
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
        a++;
    }

    @Override
    public void render(Graphics graphics) {
        //Test the player drawing.
        world.render(graphics);
        player.render(graphics);
        enemy.render(graphics);
        controller.render(graphics);
    }

    public float getObjectCount() {
        return enemyCount;
    }

    public void setObjectCount(float enemyCount) {
        this.enemyCount = enemyCount;
    }

}
