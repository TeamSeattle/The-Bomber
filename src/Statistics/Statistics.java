package Statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {

    public static TreeMap<Integer,ArrayList<String>> topTen;

    public Statistics(){
        topTen = new TreeMap<>();
        loadScores();

        print();
    }

    private static void addScores(Integer key, String value) {
        ArrayList tempList = null;

        if (topTen.containsKey(key)) {
            tempList = topTen.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        topTen.put(key,tempList);
    }

    public static void loadScores(){
        File file = new File("resources/Stats/Stats");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            for (int i = 0; i < 10; i++) {
                String[] line = bufferedReader.readLine().split("\\s+");
                int points = Integer.parseInt(line[0]);
                String name = line[1];

                addScores(points,name);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Stats not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong! Can't load stats.");
            e.printStackTrace();
        }
    }

    public static void print(){
        for (Map.Entry<Integer,ArrayList<String>> set : topTen.entrySet()) {
            for (String s : set.getValue()) {
                System.out.println(set.getKey() + " " + s);
            }
        }
    }

    public static ArrayList<String> getScores(){

        ArrayList<String> scores = new ArrayList<>();

        int position = 10;
        for (Map.Entry<Integer,ArrayList<String>> set : topTen.entrySet()) {
            for (String s : set.getValue()) {

                String entry = "";

                if (position != 10){
                    entry = String.format("0%d  - %d %s",position,set.getKey(),s);
                } else {
                    entry = String.format("%d  - %d %s",position,set.getKey(),s);
                }

                scores.add(entry);
                position--;
            }
        }

        return scores;
    }
}
