package Challenges2019.Day2;

import Utilities.InputReader;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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

    // Finds needed values for the noun and verb. Could have been made simpler without duplicated code.
    public static String puzzleTwo(ArrayList<String> input) {
        String[] intcodeList = input.get(0).split(",");
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                String[] list = intcodeList.clone();
                int count = 0;
                String opcode = list[count];
                list[1] = Integer.toString(noun);
                list[2] = Integer.toString(verb);
                while (!opcode.equals("99") && count + 3 <= list.length) {
                    int firstPos = Integer.parseInt(list[count + 1]);
                    int secondPos = Integer.parseInt(list[count + 2]);
                    int placement = Integer.parseInt(list[count + 3]);
                    if (opcode.equals("1")) {
                        // Could have been made simpler by making the initial array and Integer array.
                        list[placement] = Integer.toString(Integer.parseInt(list[firstPos]) + Integer.parseInt(list[secondPos]));
                    } else if (opcode.equals("2")) {
                        list[placement] = Integer.toString(Integer.parseInt(list[firstPos]) * Integer.parseInt(list[secondPos]));
                    }
                    count += 4;
                    opcode = list[count];
                }
                if (list[0].equals("19690720")) {
                    return Integer.toString(100 * noun + verb);
                }
            }
        }
        return "Failed";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2019/Day2/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
