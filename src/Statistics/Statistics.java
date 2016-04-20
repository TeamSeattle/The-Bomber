package Statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {

    private static TreeMap<Integer,ArrayList<String>> topTen;
    public static String NAME;

    public Statistics(){
        topTen = new TreeMap<>(Collections.reverseOrder());
        loadScores();
        NAME = "";

        print();
    }

    public static void addScores(Integer key, String value) {
        ArrayList<String> tempList;

        if (topTen.containsKey(key)) {
            tempList = topTen.get(key);
            if(tempList == null)
                tempList = new ArrayList<>();
            tempList.add(value);
        } else {
            tempList = new ArrayList<>();
            tempList.add(value);
        }
        topTen.put(key,tempList);
    }

    private static void loadScores(){
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

    public static void saveScores(){

        while (topTen.size() > 10){
            topTen.remove(getLowest());
        }

        File file = new File("resources/Stats/Stats");

        try (PrintWriter printWriter = new PrintWriter(file)) {
            int count = 0;
            for (Map.Entry<Integer,ArrayList<String>> entry : topTen.entrySet()) {
                for (String name : entry.getValue()) {
                    if (count < 10){
                        printWriter.println(entry.getKey() + " " + name);
                    }
                    count++;
                }
            }

            printWriter.close();
            System.out.println("SAVER -> (info): All grades saved successfully!");
        } catch (FileNotFoundException ex){
            System.out.println("SAVER -> (error): Can't find file: " + file.getName());
        }
    }

    private static void print(){
        for (Map.Entry<Integer,ArrayList<String>> set : topTen.entrySet()) {
            for (String s : set.getValue()) {
                System.out.println(set.getKey() + " " + s);
            }
        }

        System.out.println(getHighest());
        System.out.println(getLowest());
    }

    public static ArrayList<String[]> getScores(){

        ArrayList<String[]> scores = new ArrayList<>();

        for (Map.Entry<Integer,ArrayList<String>> set : topTen.entrySet()) {
            for (String name : set.getValue()) {

                String[] entry =  new String[2];
                entry[0] = set.getKey().toString();
                entry[1] = name;

                scores.add(entry);
            }
        }

        return scores;
    }

    private static int getHighest(){

        int highest = 0;
        for (Map.Entry<Integer,ArrayList<String>> entry : topTen.entrySet() ) {
            if (entry.getKey() > highest) {
                highest = entry.getKey();
            }
        }

        return highest;
    }

    public static int getLowest(){

        int lowest = getHighest();
        for (Map.Entry<Integer,ArrayList<String>> entry : topTen.entrySet() ) {
            if (entry.getKey() < lowest) {
                lowest = entry.getKey();
            }
        }

        return lowest;
    }
}
