package Challenges2018.Day3;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solutions to the Day Three Puzzles.
 * @Author Afaq Anwar
 * @Version 05/03/2019
 */
public class Solution {
    // Finds the square inches of claims that overlap.
    public static String puzzleOne(ArrayList<String> input) {
        String[][] fabric = new String[1000][1000];
        for (String claim : input) {
            String[] splitClaim = claim.split(" " );
            String[] inchesAway = splitClaim[2].replace(":", "").split(",");
            int row = Integer.parseInt(inchesAway[1]);
            int column = Integer.parseInt(inchesAway[0]);
            String[] limits = splitClaim[3].split("x");
            int rowLimit = row + Integer.parseInt(limits[1]);
            int columnLimit = column + Integer.parseInt(limits[0]);
            fillFabricMap(fabric, row, column, rowLimit, columnLimit);
        }
        int squareInches = 0;
        for (String[] row : fabric) {
            for (String cell : row) {
                // Overlaps are marked with a "G".
                if (cell != null && cell.equals("G")) {
                    squareInches++;
                }
            }
        }
        return Integer.toString(squareInches);
    }

    /**
     * Puzzle One helper.
     * Fills the 2D String Array with an X or G based on it's claim status.
     * @param map 2D String Array that represents the piece of Fabric.
     * @param row Integer that represents the claims row start point.
     * @param column Integer that represents the claims column start point.
     * @param rowLimit Integer that serves as a limit for the row size.
     * @param columnLimit Integer that servers as a limit for the column size.
     */
    public static void fillFabricMap(String[][] map, int row, int column, int rowLimit, int columnLimit) {
        for (int x = row; x < rowLimit; x++) {
            for (int y = column; y < columnLimit; y++) {
                if (map[x][y] == null) {
                    map[x][y] = "X";
                } else {
                    map[x][y] = "G";
                }
            }
        }
    }

    public static String puzzleTwo(ArrayList<String> input) {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day3/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
