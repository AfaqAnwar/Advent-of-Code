package Challenges2018.Day3;

import Utilities.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Solutions to the Day Three Puzzles.
 * @Author Afaq Anwar
 * @Version 05/06/2019
 */
public class Solution {
    private static HashMap<String, Boolean> overlapLog = new HashMap<>();

    // Finds the square inches of claims that overlap.
    public static String puzzleOne(ArrayList<String> input) {
        String[][] fabric = new String[1000][1000];
        for (String claim : input) {
            String[] splitClaim = claim.split(" " );
            String claimId = splitClaim[0];
            // Initially each claim doesn't overlap anything.
            overlapLog.put(claimId, false);
            String[] inchesAway = splitClaim[2].replace(":", "").split(",");
            int row = Integer.parseInt(inchesAway[1]);
            int column = Integer.parseInt(inchesAway[0]);
            String[] limits = splitClaim[3].split("x");
            int rowLimit = row + Integer.parseInt(limits[1]);
            int columnLimit = column + Integer.parseInt(limits[0]);
            // The status of whether or not the current claim has overlapped is stored.
            boolean overlapped = fillFabricMap(fabric, row, column, rowLimit, columnLimit, claimId, overlapLog);
            // The HashMap is updated with the new value.
            overlapLog.replace(claimId, overlapped);
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
     * Puzzle One / Two helper.
     * Fills the 2D String Array with an X or G based on it's claim status.
     * @param map 2D String Array that represents the piece of Fabric.
     * @param row Integer that represents the claims row start point.
     * @param column Integer that represents the claims column start point.
     * @param rowLimit Integer that serves as a limit for the row size.
     * @param columnLimit Integer that servers as a limit for the column size.
     * @Return True or False depending on if the current ID overlapped any squares.
     */
    public static boolean fillFabricMap(String[][] map, int row, int column, int rowLimit, int columnLimit, String id, HashMap<String, Boolean> overlapLog) {
        boolean overlapped = false;
        for (int x = row; x < rowLimit; x++) {
            for (int y = column; y < columnLimit; y++) {
                if (map[x][y] == null) {
                    map[x][y] = id;
                } else {
                    // If a claim overlaps the old claim's status also needs to be updated.
                    overlapLog.replace(map[x][y], true);
                    map[x][y] = "G";
                    overlapped = true;
                }
            }
        }
        return overlapped;
    }

    // Finds the ID with no overlaps.
    // Uses the global HashMap in order to solve, this was more elegant than having duplicate with a slightly different helper method.
    public static String puzzleTwo() {
        for (String id : overlapLog.keySet()) {
            if (!overlapLog.get(id)) {
                return id;
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day3/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo());
    }
}
