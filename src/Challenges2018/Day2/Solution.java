package Challenges2018.Day2;

import Challenges2018.InputReader;

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

    /**
     * Finds two Strings with the most amount of similar characters.
     * @param input
     * @return The characters which are similar between both Strings.
     */
    public static String puzzleTwo(ArrayList<String> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            String[] strArr = input.get(i).split("");
            for (int j = i + 1; j < input.size(); j++) {
                String[] strArrCompare = input.get(j).split("");
                int different = 0;
                int differentIndex = 0;
                for (int k = 0; k < strArr.length; k++) {
                    if (!strArr[k].equals(strArrCompare[k])) {
                        different++;
                        differentIndex = k;
                    }
                }
                if (different == 1) {
                    strArr[differentIndex] = "";
                    String returnStr = "";
                    for (String currChar : strArr) {
                        returnStr += currChar;
                    }
                    return returnStr;
                }
            }
        }
        return "ERROR";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day2/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
