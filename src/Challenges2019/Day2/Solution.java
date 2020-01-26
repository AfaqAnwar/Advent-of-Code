package Challenges2019.Day2;

import Utilities.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solutions to the Day Two Puzzles.
 * @Author Afaq Anwar
 * @Version 01/31/2020
 */
public class Solution {
    // Finds the intcode at position 0.
    public static String puzzleOne(ArrayList<String> input) {
        String[] intcodeList = input.get(0).split(",");
        intcodeList[1] = "12";
        intcodeList[2] = "2";
        int count = 0;
        String opcode = intcodeList[count];
        while (!opcode.equals("99") && count + 3 <= intcodeList.length) {
            int firstPos = Integer.parseInt(intcodeList[count + 1]);
            int secondPos = Integer.parseInt(intcodeList[count + 2]);
            int placement = Integer.parseInt(intcodeList[count + 3]);
            if (opcode.equals("1")) {
                // Could have been made simpler by making the initial array and Integer array.
                intcodeList[placement] = Integer.toString(Integer.parseInt(intcodeList[firstPos]) + Integer.parseInt(intcodeList[secondPos]));
            } else if (opcode.equals("2")) {
                intcodeList[placement] = Integer.toString(Integer.parseInt(intcodeList[firstPos]) * Integer.parseInt(intcodeList[secondPos]));
            }
            count += 4;
            opcode = intcodeList[count];
        }
        return intcodeList[0];
    }

    // Finds the amount of fuel needed for each module.
    public static String puzzleTwo(ArrayList<String> input) {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2019/Day2/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
