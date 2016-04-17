package States;

import Input.KeyManager;
import Input.MouseManager;
import Main.Engine;
import Graphics.Assets;
import java.awt.*;

public class PauseState extends State {
    public PauseState(Engine engine) {
        super(engine);
        name = "Pause";
    }
    int a = 0;
    @Override
    public void tick() {
        if (KeyManager.escape && a > 20) {
            StateManager.setCurrentState(Engine.gameState);
            System.out.println("SWITCHED STATE : GameState");
            a = 0;
        }
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 200 && MouseManager.getY < 270) && a > 20) {
            StateManager.setCurrentState(Engine.gameState);
            System.out.println("SWITCHED STATE : GameState");
            a = 0;
        }
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 300 && MouseManager.getY < 370) && a > 20) {
            // NO SETTINGS MENU
        }
        if (MouseManager.isClicked == 1 &&
                (MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570) && a > 20) {
            StateManager.setCurrentState(Engine.menuState);
            System.out.println("SWITCHED STATE : MenuState");
            a = 0;
        }

        a++;
    }

    @Override
    public void render(Graphics graphics) {
        // Background
        graphics.drawImage(Assets.menu_background, 0, 0, null);

        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 200 && MouseManager.getY < 270)) {
            graphics.drawImage(Assets.start_menu_button_hover, 347, 200, null);
        } else {
            graphics.drawImage(Assets.start_menu_button, 347, 200, null);
        }

        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 300 && MouseManager.getY < 370)) {
            graphics.drawImage(Assets.settings_menu_button_hover, 347, 300, null);
        } else {
            graphics.drawImage(Assets.settings_menu_button, 347, 300, null);
        }

        if ((MouseManager.getX > 347 && MouseManager.getX < 550) &&
                (MouseManager.getY > 500 && MouseManager.getY < 570)) {
            graphics.drawImage(Assets.close_menu_button_hover, 347, 500, null);
        } else {
            graphics.drawImage(Assets.close_menu_button, 347, 500, null);
        }
    }
}
