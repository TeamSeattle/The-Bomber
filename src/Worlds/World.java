package Worlds;

import Tiles.Tile;

import java.awt.*;
import java.io.*;

public class World {

    private final int WORLD_WIDTH = 14;
    private final int WORLD_HEIGHT = 15;

    private int[] background;
    private int[][] foreground;

    public World(String path){
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics graphics){
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                geTile(x,y).render(graphics,x * 64,y * 64);
            }
        }
    }

    private Tile geTile(int x, int y){
        Tile tile = Tile.tiles[foreground[y][x]];

        if (tile == null){
            return Tile.empty;
        }

        return tile;
    }

    private void loadWorld(String path){

        background = new int[3];
        foreground = new int[WORLD_HEIGHT][WORLD_WIDTH];
        File file = new File("resources/levels/" + path);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();
            if (!line.equals("#leveldata")) {
                System.out.println("Incorrect world file!");
            }

            // Load Background
            line = bufferedReader.readLine();
            if (line.equals("#background")){
                loadBackground(bufferedReader.readLine());
            }

            // Load Foreground
            line = bufferedReader.readLine();
            if (line.equals("#foreground")){

                int row = 0;
                while ((line = bufferedReader.readLine()) != null) {

                    String[] lineCells = line.split(" ");

                    for (int cell = 0; cell < WORLD_WIDTH; cell++) {
                        int i = Integer.parseInt(lineCells[cell]);
                        foreground[row][cell] = i;
                    }
                    row++;
                }
            }

            // Print for debugging
            for (int x = 0; x < WORLD_HEIGHT; x++) {
                for (int y = 0; y < WORLD_WIDTH; y++) {
                    System.out.print(foreground[x][y] + " ");
                }
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            System.out.println("World not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong! Can't load word: " + path);
            e.printStackTrace();
        }
    }

    private void loadBackground(String input){
        String[] backgroundInput = input.split("\\s+");
        for (int i = 0; i < 3; i++) {
            background[i] = Integer.parseInt(backgroundInput[i]);
        }
    }
}
