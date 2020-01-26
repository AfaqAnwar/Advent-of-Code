package Challenges2018.Day4;

import Utilities.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solutions to the Day Four Puzzles.
 * @Author Afaq Anwar
 * @Version 05/15/2019
 */
public class Solution {
    private static ArrayList<Guard> guards = new ArrayList<>();

    // Finds the Guard that is asleep the most.
    public static String puzzleOne(ArrayList<String> input) {
        Collections.sort(input);
        for (int i = 0; i < input.size() - 1; i++) {
            String statusKeyword = input.get(i).split(" ")[3];
            if (!statusKeyword.equals("asleep") && !statusKeyword.equals("up")) {
                int currentID = Integer.parseInt(statusKeyword.replace("#", ""));
                int start = i + 1;
                int end = 0;
                int increment = start;
                while (end == 0 && increment < input.size()) {
                   if (!input.get(increment).split(" ")[3].equals("asleep") && !input.get(increment).split(" ")[3].equals("up") || increment == input.size() - 1) {
                       end = increment;
                       // Since the generateLogList method is exclusive in it's loop this needs to be allowed so the last log is entered.
                       if (end == input.size() - 1) {
                           end++;
                       }
                   }
                   increment++;
                }
                if (!checkIfExists(guards, currentID)) {
                    Guard guard = new Guard(currentID);
                    guard.updateMinutes(generateLogList(input, start, end));
                    guards.add(guard);
                } else {
                    int index = getGuardIndex(guards, currentID);
                    guards.get(index).updateMinutes(generateLogList(input, start, end));
                }
            }
        }
        // Finds the guard that is asleep the most.
        Guard laziestGuard = findLaziestGuard(guards);
        return Integer.toString(laziestGuard.getMostFrequentMinute() * laziestGuard.getId());
    }

    // Self-Explanatory Helper Methods.
    public static ArrayList<String> generateLogList(ArrayList<String> input, int start, int end) {
        ArrayList<String> log = new ArrayList<>();
        for (int i = start; i < end; i++) {
            log.add(input.get(i));
        }
        return log;
    }

    public static boolean checkIfExists(ArrayList<Guard> list, int id) {
        for (Guard guard : list) {
            if (guard.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static int getGuardIndex(ArrayList<Guard> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the "laziest" guard, the one with the most minutes slept.
     * @param guards ArrayList of Guards.
     * @return Guard that has slept the most.
     */
    public static Guard findLaziestGuard(ArrayList<Guard> guards) {
        Guard chosen = null;
        int mostMinutes = 0;
        for (Guard guard : guards) {
            int totalSleep = guard.calculateTotalSleep();
            if (totalSleep > mostMinutes) {
                chosen = guard;
                mostMinutes = guard.calculateTotalSleep();
            }
        }
        return chosen;
    }

    // Finds the Guard with asleep the most on the same minute.
    public static String puzzleTwo() {
        int minute = 0;
        int amount = 0;
        Guard chosen = null;
        for (Guard guard : guards) {
            // If the guard has no logs, it will skip over to avoid a Null Pointer Exception.
            if (guard.getMinuteMap().size() != 0 && guard.getMostFrequentMinute() != 0) {
                int currentAmount = guard.getMinuteMap().get(guard.getMostFrequentMinute());
                if (currentAmount > amount) {
                    amount = currentAmount;
                    minute = guard.getMostFrequentMinute();
                    chosen = guard;
                }
            }
        }
        return Integer.toString(minute * chosen.getId());
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day4/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo());
    }
}
