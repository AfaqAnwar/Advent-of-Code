package Challenges2018.Day5;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solutions to the Day Five Puzzles.
 * @Author Afaq Anwar
 * @Version 05/16/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) { return ""; }

    public static String puzzleTwo() { return ""; }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day5/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo());
    }
}
