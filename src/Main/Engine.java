/* ===================
 *        INFO
 *
 * ================================================
 * The graphics object is the object that we will
 * use to draw stuff to the canvas which will be
 * rendered to the screen
 *
 * For more info:
 * https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
 *
 * ================================================
 * The BufferStrategy object represents the mechanism
 * with which to organize complex memory on a particular
 * Canvas or Window.
 * We will use triple (3) buffering
 *
 * For more info:
 * https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferStrategy.html
 *
 * ================================================
 * About the game loop.
 * It is basically one frame.
 * For
 * http://www.koonsolo.com/news/dewitters-gameloop/
 *
 * ===================
 */

package Main;

import DIsplay.Display;
import Graphics.Assets;
import Input.KeyManager;
import Input.MouseManager;
import States.*;
import States.AllStates.*;
import Statistics.Statistics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

// This class will be the main in our game, it will handle.
public class Engine implements Runnable {

    // Properties that we will use
    private Display display;
    private Thread thread;
    private static final int FRAMES_PER_SECOND = 60;

    // This boolean will regulate the GAME LOOP
    private boolean running = false;

    // Properties for rendering
    private BufferStrategy bufferStrategy;
    public static Graphics graphics;

    // Stats
    private static Statistics statistics;

    // All the states
    public static State gameState;
    public static State menuState;
    public static State deadState;
    public static State pauseState;
    public static State levelPickerState;
    public static State infoState;
    public static State statsState;
    public static State exitState;

    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // Volume Boolean
    public static boolean volume;

    /**
     * Constructor
     */
    public Engine() {
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    /**
     * This is the method that will be called
     * when we start the thread Main game loop
     */
    @Override
    public void run() {
        initialize();

        // This handles the frames per second
        // Don't ask about this code
        double timePerTick = 1_000_000_000 / FRAMES_PER_SECOND;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {

            // This is also part of the code to limit the game loop ticks
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();

                // For the FPS
                ticks++;
                delta--;
            }

            // FPS Counter
            if (timer >= 1_000_000_000) {
                System.out.println("> " + ticks + " FPS / Ticks");
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }


    /**
     * Setup everything we need for the game
     */
    private void initialize() {

        // Initialize Stats
        statistics = new Statistics();

        // Get the user name/username
        Statistics.NAME = JOptionPane.showInputDialog(Display.mainFrame, "Choose your username:");
        if (Statistics.NAME == null) {
            System.exit(0);
        }

        // Initialize display
        display = new Display();

        //Initialize key manager
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        // Initialize assets
        Assets.initialize();

        // Initialize states
        gameState = new GameState(this);
        menuState = new MenuState(this);
        deadState = new DeadState(this);
        pauseState = new PauseState(this);
        levelPickerState = new LevelPickerState(this);
        infoState = new InfoState(this);
        statsState = new StatsState(this);
        exitState = new ExitPromptState(this);
        StateManager.setCurrentState(menuState);

        // Volume
        volume = true;

        // Print info
        System.out.println("Current State is: " + StateManager.getCurrentState().name);
        System.out.println("===============");
    }


    /**
     * This method is called every frame
     * It updates everything (values, object etc.)
     * + keyManager
     */
    private void tick() {
        keyManager.tick();
        mouseManager.tick();
        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().tick();
        }
    }


    /**
     * This method is called every frame
     * It will render everything After the tick(); does it job
     */
    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            // If we run the game for the fist time it wont have a bufferStrategy and we
            // will have to create one. It is 3 because we want to buffer exactly 3 frames
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        // Initialize the graphics object
        graphics = bufferStrategy.getDrawGraphics();
        // Clear the screen
        Display.clearScreen();

        // Draw Here

        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().render(graphics);
        }

        // End Drawing

        graphics.dispose();
        bufferStrategy.show();
    }

    /**
     * The method will start the thread. Initialize the thread object.
     * When we call thread.start(); the thread will call the run() method.
     */
    synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(Engine.this);
        thread.start();
    }


    /**
     * The method will stop the thread thread.join gives exception
     */
    private synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Look where you stop the thread." +
                        " This will be in Engine class stop().");
                e.printStackTrace();
            }
        }
    }

    public static Engine getEngine() {
        return new Engine();
    }

    public State getGameState() {
        return gameState;
    }
}