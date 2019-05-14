package Challenges2018.Day4;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Solutions to the Day Four Puzzles.
 * @Author Afaq Anwar
 * @Version 05/14/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) {
        Collections.sort(input);
        ArrayList<Gaurd> gaurds = new ArrayList<>();
        int id = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.size(); i++) {
            String statusKeyword = input.get(i).split(" ")[3];
            if (!statusKeyword.equals("asleep") && !statusKeyword.equals("up")) {
                int currentID = Integer.parseInt(statusKeyword.replace("#", ""));
                if (currentID != id) {
                    start = i + 1;
                    end = i;
                    while (input.get(end).split(" ")[3].equals("asleep") || input.get(end).split(" ")[3].equals("up")) {
                        end++;
                    }
                    Gaurd gaurd = new Gaurd(currentID);
                    gaurd.updateMinutes(generateLogList(input, start, end));
                    gaurds.add(gaurd);
                }
            }
        }
        return "";
    }

    public static ArrayList<String> generateLogList(ArrayList<String> input, int start, int end) {
        ArrayList<String> log = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            log.add(input.get(i));
        }
        return log;
    }

    public static String puzzleTwo() {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day4/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo());
    }
}
