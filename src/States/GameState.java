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

import java.awt.*;

import Graphics.Assets;

public class GameState extends State {

    /**
     * Constructor
     */
    public GameState() {
        name = "Game";
    }

    @Override
    public void tick() {

    }

    int i = 0;
    int x = 0;

    @Override
    public void render(Graphics graphics) {

        // TEST CODE
        graphics.drawImage(Assets.blue_solid,0,0,1000,1000,null);

        if (i < -128){
            i = 0;
        }
        graphics.drawImage(Assets.water, i - 128, 800, null);
        graphics.drawImage(Assets.water, i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH + i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 2 + i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 3 + i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 4 + i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 5 + i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 6 + i, 800, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 7 + i, 800, null);

        if (x > 128){
            x = 0;
        }
        // WATER 2
        graphics.drawImage(Assets.water, x - 128, 875, null);
        graphics.drawImage(Assets.water, x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH + x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 2 + x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 3 + x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 4 + x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 5 + x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 6 + x, 875, null);
        graphics.drawImage(Assets.water, Assets.IMAGE_WIDTH * 7 + x, 875, null);

        // TESTING COORDINATES
        graphics.drawImage(Assets.speed,896 / 2 - 32,1024 / 2 - 32,null);
        i--;
        x++;
    }
}
