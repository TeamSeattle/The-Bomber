package Main;

public class Launcher {

    public static Engine engine;

    /**
     * This will be main method that will be the starting point
     * When someone opens the game this is the method that will be called first
     */
    public static void main(String[] args) {
        engine = new Engine();
        engine.start();
    }
}
