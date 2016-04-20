package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public static boolean left;
    public static boolean right;
    public static boolean escape;
    public static boolean auraSwitch;
    public static boolean speedSwitch;
    public static boolean boundsSwitch;
    public static boolean killYourSelf;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        left = keys[KeyEvent.VK_LEFT] | keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] | keys[KeyEvent.VK_D];
        escape = keys[KeyEvent.VK_ESCAPE];

        // CHEATS
        boundsSwitch = keys[KeyEvent.VK_F1];
        killYourSelf = keys[KeyEvent.VK_F2];
        auraSwitch = keys[KeyEvent.VK_F3];
        speedSwitch = keys[KeyEvent.VK_F4];
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
