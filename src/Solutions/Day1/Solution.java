package Solutions.Day1;

import Solutions.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solutions to the Day One Puzzles.
 * @Author Afaq Anwar
 * @Version 05/01/2019
 */
public class Solution {
    // Calculates the final frequencies.
    public static String puzzleOne(ArrayList<String> input) {
        int frequency = 0;
        for (String s : input) {
            if (s.contains("+")) {
                frequency += Integer.parseInt(s.substring(1));
            } else {
                frequency -= Integer.parseInt(s.substring(1));
            }
        }
        return Integer.toString(frequency);
    }

    /**
     *  Loops through the list forever until a previously seen frequency has been found.
     *  This could be more efficient, however I'm just writing what comes to my head first.
     */
    public static String puzzleTwo(ArrayList<String> input) {
        ArrayList<Integer> previousFrequencies = new ArrayList<>();
        int frequency = 0;
        for(;;) {
            for (String s : input) {
                if (s.contains("+")) {
                    frequency += Integer.parseInt(s.substring(1));
                } else {
                    frequency -= Integer.parseInt(s.substring(1));
                }
                if (previousFrequencies.contains(frequency)) {
                    return Integer.toString(frequency);
                }
                previousFrequencies.add(frequency);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Solutions/Day1/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
