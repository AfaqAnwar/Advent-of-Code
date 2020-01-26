package Challenges2019.Day1;

import Utilities.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Solutions to the Day One Puzzles.
 * @Author Afaq Anwar
 * @Version 01/26/2020
 */
public class Solution {
    // Finds the amount of fuel needed.
    public static String puzzleOne(ArrayList<String> input) {
        int totalFuel = 0;
        for (String fuelMass : input) {
            int currentAmount = Integer.parseInt(fuelMass);
            // Java rounds down.
            currentAmount /= 3;
            currentAmount -= 2;

            totalFuel += currentAmount;
        }
        return Integer.toString(totalFuel);
    }

    // Finds the amount of fuel needed for each module.
    public static String puzzleTwo(ArrayList<String> input) {
        int totalRequirement = 0;
        for (String module : input) {
            int currentModule = Integer.parseInt(module);
            while (currentModule > 0) {
                currentModule /= 3;
                currentModule -= 2;
                // Checks for last case because the while loop is not concurrent.
                if (currentModule > 0) {
                    totalRequirement += currentModule;
                }
            }
        }
        return Integer.toString(totalRequirement);
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2019/Day1/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
