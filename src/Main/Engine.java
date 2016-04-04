package Main;

import DIsplay.Display;

// This class will be the main in our game
// It will handle
public class Engine implements Runnable{

    // Properties that we will use
    // ===========================
    private Display display;
    private Thread thread;
    // This boolean will regulate the GAME LOOP
    private boolean running = false;

    /**
     * Constructor
     */
    public Engine(){

    }

    /**
     * This is the method that will be called
     * when we start the thread
     * Main game loop
     */
    @Override
    public void run() {
        // Setup things
        initialize();

        while (running){
            // First update
            thick();
            // Then render everything
            render();
        }

        // After we exit the loop
        // we will have to stop the thread
        stop();
    }

    /**
     * Do some things before we start the
     * main game loop
     */
    private void initialize(){
        display = new Display();
    }

    /**
     * This method is called every frame
     * It updates everything (values, object etc.)
     */
    private void thick(){

    }

    /**
     * This method is called every frame
     * It will render everything
     * After the thick(); does it job
     */
    private void render(){

    }

    /**
     * The method will start the thread
     * Initialize the thread object
     * When we call thread.start(); the thread
     * will call the run() method
     */
    public synchronized void start(){
        // Only if the game is not running
        if (running){
            return;
        }
        thread = new Thread(this);
        thread.start();
    }

    /**
     * The method will stop the thread
     * thread.join gives exception
     */
    public synchronized void stop(){
        // Only if the game is running
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Look where you stop the thread.");
                e.printStackTrace();
            }
        }
    }
}
