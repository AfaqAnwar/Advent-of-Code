package Solutions.Day2;

import Solutions.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Solutions to the Day Two Puzzles.
 * @Author Afaq Anwar
 * @Version 05/02/2019
 */
public class Solution {
    // Finds the checksum.
    public static String puzzleOne(ArrayList<String> input) {
        int twoCount = 0;
        int threeCount = 0;
        for (String curr : input) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            boolean twoFound = false;
            boolean threeFound = false;
            // Each character is entered into a HashMap which holds the Integer value of how many are in the current input.
            for (int i = 0; i < curr.length(); i++) {
                char currentChar = curr.charAt(i);
                charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            }
            // Finds the characters with counts of twos and threes.
            for (int count : charCount.values()) {
                if (count == 2 && !twoFound) {
                    twoCount++;
                    twoFound = true;
                } else if (count == 3 && !threeFound) {
                    threeCount++;
                    threeFound = true;
                }
            }
        }
        return Integer.toString(twoCount * threeCount);
    }

    public static String puzzleTwo(ArrayList<String> input) {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Solutions/Day2/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
