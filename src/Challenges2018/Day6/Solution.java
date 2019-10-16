package Challenges2018.Day6;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solutions to the Day Six Puzzles.
 * @Author Afaq Anwar
 * @Version 10/15/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) {
        ArrayList<Point> allPoints = new ArrayList<>();
        for (String line : input) {
            String[] splitLocations = line.split(",");
            allPoints.add(new Point(Integer.parseInt(splitLocations[0].trim()), Integer.parseInt(splitLocations[1].trim()), false));
        }
        return "";
    }

    public static String puzzleTwo(ArrayList<String> input) {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day6/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
