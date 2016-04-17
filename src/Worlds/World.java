package Worlds;

import Tiles.Tile;

import java.awt.*;
import java.io.*;

public class World {

    // Properties
    private final int WORLD_WIDTH = 14;
    private final int WORLD_HEIGHT = 15;

    // Properties to store the world
    private int[] background;
    private int bottomBackground;
    private int[][] foreground;
    private boolean isThereWaterLine;

    /**
     * Constructor
     * @param path -> Path to the world file
     */
    public World(String path){
        loadWorld(path);
    }

    /**
     * This method is called every frame
     */
    public void tick(){

    }

    /**
     * This method is called every frame
     * =================================
     * After we load the world into our matrix we
     * can render it.
     * The render order is important
     * @param graphics -> Take Graphics Object
     */
    public void render(Graphics graphics){
        // Render Main Background
        for (int code : background) {
            geTile(code).render(graphics,0,0);
        }

        // Render bottom Background
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 12; y < WORLD_HEIGHT; y++) {
                geTile(bottomBackground).render(graphics, x * 64,y * 64);
            }
        }

        // Render foreground
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                geTile(x,y).render(graphics,x * 64,y * 64);
            }
        }

        // Render water
        if (isThereWaterLine){
            geTile(80).render(graphics,64 * 14,64 * 14);
        }
    }


    /**
     * # First Overload
     * This method returns a Tile object
     * from a specific code
     * @param x ->
     * @param y ->
     * @return -> The tile with that index
     */
    private Tile geTile(int x, int y){
        Tile tile = Tile.tiles[foreground[y][x]];
        if (tile == null){
            return Tile.empty;
        }
        return tile;
    }


    /**
     * # Second Overload
     * This method returns a Tile object
     * from a specific code
     * @param code -> Index of the tile
     * @return -> The tile with that index
     */
    private Tile geTile(int code){
        Tile tile = Tile.tiles[code];
        if (tile == null){
            return Tile.empty;
        }
        return tile;
    }


    /**
     * This is the main method where we load the whole world
     * from a file of choice.
     * @param path -> path to the file
     */
    private void loadWorld(String path){

        background = new int[3];
        foreground = new int[WORLD_HEIGHT][WORLD_WIDTH];
        File file = new File("resources/levels/" + path);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();
            if (!line.equals("#leveldata")) {
                System.out.println("Incorrect world file!");
            }

            // region Load Background
            line = bufferedReader.readLine();
            if (line.equals("#background")){
                loadBackground(bufferedReader.readLine());
            }
            // endregion

            // region Load Foreground
            line = bufferedReader.readLine();
            if (line.equals("#foreground")){
                int row = 0;
                while (!(line = bufferedReader.readLine()).equals("#bottomBackground")) {

                    String[] lineCells = line.split("\\s+");

                    for (int cell = 0; cell < WORLD_WIDTH; cell++) {
                        int i = Integer.parseInt(lineCells[cell]);
                        foreground[row][cell] = i;
                    }
                    row++;
                }
            }
            // endregion

            // region Load bottom background
            if (line.equals("#bottomBackground")){
                line = bufferedReader.readLine();
                bottomBackground = Integer.parseInt(line);
            }
            // endregion

            // region Load waterline
            line = bufferedReader.readLine();
            if (line.equals("#waterLine")){
                line = bufferedReader.readLine();
                if (line.equals("true")) isThereWaterLine = true;
                else isThereWaterLine = false;
            }
            // endregion

            // Info
            printDebugInfo();

        } catch (FileNotFoundException e) {
            System.out.println("World not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong! Can't load word: " + path);
            e.printStackTrace();
        }
    }


    /**
     * This method loads the main background of the world
     * @param input -> background codes
     */
    private void loadBackground(String input){
        String[] backgroundInput = input.split("\\s+");
        for (int i = 0; i < 3; i++) {
            background[i] = Integer.parseInt(backgroundInput[i]);
        }
    }


    /**
     * This method will show us what is loaded for the world
     */
    private void printDebugInfo(){
        // Print for debugging
        System.out.println("Map:");
        for (int x = 0; x < WORLD_HEIGHT; x++) {
            for (int y = 0; y < WORLD_WIDTH; y++) {
                System.out.print(foreground[x][y] + " ");
            }
            System.out.println("");
        }
        System.out.println("Bottom Background code: " + bottomBackground);
        System.out.println("Waterline: " +isThereWaterLine);
    }
}
