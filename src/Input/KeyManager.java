package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public static boolean left;
    public static boolean right;
    public static boolean escape;
    public static boolean auraSwitch;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        left = keys[KeyEvent.VK_LEFT] | keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] | keys[KeyEvent.VK_D];
        escape = keys[KeyEvent.VK_ESCAPE];
        auraSwitch = keys[KeyEvent.VK_E];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
