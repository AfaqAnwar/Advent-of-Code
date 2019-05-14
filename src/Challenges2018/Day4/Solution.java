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
 * @Version 05/13/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) {
        Collections.sort(input);
        int id = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.size(); i++) {
            int currentID = Integer.parseInt(input.get(i).split(" ")[2]);
            if (currentID != id) {
                start = i;
            }
        }
        return "";
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
