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

import Display.Display;
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
    private Graphics graphics;

    /**
     * Constructor
     */
    public Engine() {

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
        double timePerTick =  1_000_000_000 / FRAMES_PER_SECOND;
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

            if (delta >= 1){
                tick();
                render();

                // For the FPS
                ticks++;
                delta--;
            }

            // FPS Counter // Show FPS every second
            if (timer >= 1_000_000_000){
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
        display = new Display();
    }

    /**
     * This method is called every frame
     * It updates everything (values, object etc.)
     */
    private void tick() {

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
        graphics.clearRect(0, 0, Display.WINDOW_WIDTH, Display.WINDOW_HEIGHT);

        // Draw HERE !!
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, 100, 100);
        // End Drawing !!

        graphics.dispose();
        bufferStrategy.show();
    }

    /**
     * The method will start the thread. Initialize the thread object.
     * When we call thread.start(); the thread will call the run() method.
     */
    public synchronized void start() {
        // Only if the game is not running
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
    public synchronized void stop() {
        // Only if the game is running
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
}
