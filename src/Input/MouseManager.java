package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    private int  x, y, click;
    public static int getX, getY, isClicked;

    public MouseManager() {
        click = 0;
    }

    public void tick() {
        isClicked = click;
        getX = x;
        getY = y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        click = e.BUTTON1;
        x = e.getX();
        y = e.getY();
        System.out.println(click + " " + x + " " + y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click = 0;
        x = 0;
        y = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
