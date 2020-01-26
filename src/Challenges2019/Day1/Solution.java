package Challenges2019.Day1;

import Utilities.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solutions to the Day One Puzzles.
 * @Author Afaq Anwar
 * @Version 01/26/2020
 */
public class Solution {
    // Finds the amount of fuel needed.
    public static String puzzleOne(ArrayList<String> input) {
        int total = 0;
        for (String fuel : input) {
            int amount = Integer.parseInt(fuel);
            // Java rounds down.
            amount /= 3;
            amount -= 2;
            total += amount;
        }
        return Integer.toString(total);
    }

    public static String puzzleTwo(ArrayList<String> input) {
      return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2019/Day1/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
