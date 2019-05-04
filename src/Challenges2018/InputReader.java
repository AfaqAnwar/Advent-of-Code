package Challenges2018;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simple file reader to parse a text file into an ArrayList.
 * @Author Afaq Anwar
 * @Version 05/01/2019
 */
public class InputReader {
    private ArrayList<String> input;

    public InputReader(File inputFile) throws IOException {
        Scanner inputScanner = new Scanner(inputFile);
        this.input = new ArrayList<>();
        while (inputScanner.hasNext()) {
            input.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }

    public ArrayList<String> getInput() { return input; }
}
