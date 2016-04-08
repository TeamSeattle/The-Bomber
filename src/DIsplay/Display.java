package Display;

import Main.Engine;
import javax.swing.*;
import java.awt.*;

public class Display {

    // Properties that we will use
    // ===========================
    private JFrame mainFrame;
    private Canvas mainCanvas;

    // Width and the height are in pixels
    public static final String GAME_NAME = "The Bomber";
    public static final int WINDOW_WIDTH = 896;
    public static final int WINDOW_HEIGHT = 1024;


    /**
     * Constructor
     */
    public Display(){
        createDisplay();
    }


    /**
     * This is the method that will take care
     * and set up the JFrame which is the display
     */
    private void createDisplay(){

        // Dimension is an object that stores two numbers
        // And is used for the window and the canvas
        Dimension windowDimension = new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT);

        // Setup JFrame
        // Initialize the JFrame
        // And when we create it we can give it a name (title)
        mainFrame = new JFrame(GAME_NAME);
        // Set the size to the window (with the dimension object)
        mainFrame.setSize(windowDimension);
        // Set it that when we exit the window
        // the program will also stop running
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // This way you can't resize the window
        mainFrame.setResizable(false);
        // When you open the game it will be
        // in the center of the screen
        mainFrame.setLocationRelativeTo(null);
        // This will show the window
        mainFrame.setVisible(true);

        // Setup Canvas
        mainCanvas = new Canvas();
        // Set the size (the same of the window)
        mainCanvas.setPreferredSize(windowDimension);
        mainCanvas.setMaximumSize(windowDimension);
        mainCanvas.setMinimumSize(windowDimension);
        // Add the canvas to the JFrame
        mainFrame.add(mainCanvas);
        mainFrame.pack();

        // Prints Info to the console
        // =====================
        System.out.printf("Opened Display (%d x %d) \n",WINDOW_WIDTH,WINDOW_HEIGHT);
        System.out.println("Canvas Created\n===============");
    }


    /**
     * Returns the Canvas object which we need
     * to draw stuff on the screen
     */
    public Canvas getCanvas(){
        return this.mainCanvas;
    }


    /**
     * This method will clear the screen
     */
    public static void clearScreen(){
        Engine.graphics.clearRect(0, 0, Display.WINDOW_WIDTH, Display.WINDOW_HEIGHT);
    }
}
