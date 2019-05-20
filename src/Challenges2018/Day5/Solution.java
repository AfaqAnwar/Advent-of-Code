package Challenges2018.Day5;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solutions to the Day Five Puzzles.
 * @Author Afaq Anwar
 * @Version 05/19/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) {
        String[] units = input.get(0).split("");
        boolean destroy = false;
        int originalSize = units.length;
        int currentSize = 0;
        while (currentSize != originalSize) {
            char previous = units[0].charAt(0);
            for (int i = 1; i < units.length; i++) {
                int first = 0;
                int second = 0;
                originalSize = units.length;
                char current = units[i].charAt(0);
                if (String.valueOf(current).toLowerCase().equals(String.valueOf(previous).toLowerCase())) {
                    if (Character.isUpperCase(current)) {
                        if (!Character.isUpperCase(previous)) {
                            destroy = true;
                            first = i - 1;
                            second = i;
                        }
                    } else if (!Character.isUpperCase(current)) {
                        if (Character.isUpperCase(previous)) {
                            destroy = true;
                            first = i - 1;
                            second = i;
                        }
                    }
                }
                if (destroy) {
                    units[first] = "";
                    units[second] = "";
                    // Signifies a null value. String Equivalent - ""
                    previous = Character.MIN_VALUE;
                    destroy = false;
                } else {
                    previous = current;
                }
            }
            units = condense(units);
            currentSize = units.length;
        }
        return Integer.toString(units.length);
    }

    /**
     * Helper Method - removes all empty Strings within an Array.
     * @param arr String Array ~ preferably with empty entries.
     * @return Array of Strings with no empty entries.
     */
    public static String[] condense(String[] arr) {
        int size = arr.length;
        for (String str : arr) {
            if (str.equals("")) {
                size--;
            }
        }
        String[] newArr = new String[size];
        int count = 0;
        for (String str : arr) {
            if (!str.equals("")) {
                newArr[count] = str;
                count++;
            }
        }
        return newArr;
    }

    public static String puzzleTwo() { return ""; }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day5/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo());
    }
}
