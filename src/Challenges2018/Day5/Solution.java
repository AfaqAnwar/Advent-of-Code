package Challenges2018.Day5;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Solutions to the Day Five Puzzles.
 * @Author Afaq Anwar
 * @Version 05/20/2019
 */
public class Solution {
    private static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static HashMap<String, Integer> alphabetMap = new HashMap<>();

    /**
     * Breaks down the split units.
     * @param units String of units.
     * @return Integer that represents the length of the polymer after all possible breakdowns have occurred.
     */
    public static int findPolymerLength(String[] units) {
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
        return units.length;
    }

    // Puzzle One. Returns the Length of the original polymer after all breakdowns have occurred.
    public static String puzzleOne(ArrayList<String> input) {
        String[] units = input.get(0).split("");
        return Integer.toString(findPolymerLength(units));
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

    // Puzzle Two. Returns the length of the smallest polymer after one letter has been removed.
    public static String puzzleTwo(ArrayList<String> input) {
        // Looping through each letter of the alphabet and removes that letter.
        for (String letter : alphabet) {
            String replacedStr = input.get(0).replaceAll(letter, "").replaceAll(letter.toLowerCase(), "");
            String[] units = replacedStr.split("");
            int length = findPolymerLength(units);
            alphabetMap.put(letter, length);
        }
        return Integer.toString(findLowest(alphabetMap));
    }

    /**
     * Helper Method, finds the smallest Integer value in a valid HashMap.
     * @param map HashMap that has String keys & Integer Entries.
     * @return Smallest Integer Value within map.
     */
    public static int findLowest(HashMap<String, Integer> map) {
        int smallestValue = 100000000;
        for (String entry : map.keySet()) {
            if (map.get(entry) < smallestValue) {
                smallestValue = map.get(entry);
            }
        }
        return smallestValue;
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day5/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
