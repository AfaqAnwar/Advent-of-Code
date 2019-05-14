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
 * @Version 05/14/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) {
        Collections.sort(input);
        ArrayList<Guard> guards = new ArrayList<>();
        int id = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.size() - 1; i++) {
            String statusKeyword = input.get(i).split(" ")[3];
            if (!statusKeyword.equals("asleep") && !statusKeyword.equals("up")) {
                int currentID = Integer.parseInt(statusKeyword.replace("#", ""));
                if (currentID != id) {
                    id = currentID;
                    start = i + 1;
                    end = start;
                    while (input.get(end).split(" ")[3].equals("asleep") && end < input.size() - 1 || input.get(end).split(" ")[3].equals("up") && end < input.size() - 1) {
                        if (end < input.size() - 1) {
                            end++;
                        }
                    }
                    Guard guard = new Guard(id);
                    guard.updateMinutes(generateLogList(input, start, end));
                    guards.add(guard);
                }
            }
        }
        for (Guard guard : guards) {
            for (String date : guard.getScheduleLog().keySet()) {
                System.out.println(guard.getId() + " " + date);
                for (int i : guard.getScheduleLog().get(date)) {
                    System.out.print(i + ",");
                }
            }
        }
        Guard chosen = null;
        int mostMinutes = 0;
        for (Guard guard : guards) {
            int totalSleep = guard.calculateTotalSleep();
            if (totalSleep > mostMinutes) {
                chosen = guard;
                mostMinutes = guard.calculateTotalSleep();
            }
        }
        return Integer.toString(chosen.getMostFrequentMinute() * chosen.getId());
    }

    public static ArrayList<String> generateLogList(ArrayList<String> input, int start, int end) {
        ArrayList<String> log = new ArrayList<>();
        for (int i = start; i < end; i++) {
            log.add(input.get(i));
        }
        return log;
    }

    public static String puzzleTwo() {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day4/text.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo());
    }
}
