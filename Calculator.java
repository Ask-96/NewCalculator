package simple_calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Loop forever
        while (true) {

            // Read a line of input.
            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("exit");
                break;
            }

            final Scanner in = new Scanner(line);
            final String leftWord, operation, rightWord;

            try {
                leftWord = in.next();
                operation = in.next();
                rightWord = in.next();
            } catch (NoSuchElementException e) {
                System.err.println("should be on the same line");
                System.out.println();
                continue;
            }

            switch (operation) {
                case "+":
                    validateDoubleQuotes(leftWord);
                    validateDoubleQuotes(rightWord);

                    System.out.println(Utils.removeLastCharacter(leftWord) + Utils.removeFirstCharacter(rightWord));
                    break;
                case "-":
                    validateDoubleQuotes(leftWord);
                    validateDoubleQuotes(rightWord);

                    final String leftWordWithoutQuotes = Utils.removeAll(leftWord, "\"");
                    final String rightWordWithoutQuotes = Utils.removeAll(rightWord, "\"");

                    System.out.println('"' + Utils.removeAll(leftWordWithoutQuotes, rightWordWithoutQuotes) + '"');
                    break;
                case "*":
                    validateDoubleQuotes(leftWord);

                    final String wordWithoutQuotes = Utils.removeAll(leftWord, "\"");
                    int i = Integer.parseInt(rightWord);

                    System.out.println('"' + wordWithoutQuotes.repeat(i) + '"');
                    break;
                case "/":
                    validateDoubleQuotes(leftWord);

                    final String divisionLeftWordWithoutQuotes = Utils.removeAll(leftWord, "\"");

                    final int divider = Integer.parseInt(rightWord);

                    if (divider <= 0) {
                        throw new IllegalArgumentException("Only positive number are allowed as divider");
                    }

                    int wordCountToLeave = divisionLeftWordWithoutQuotes.length() / divider;

                    System.out.println('"' + divisionLeftWordWithoutQuotes.substring(0, wordCountToLeave) + '"');
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
    }

    static void validateDoubleQuotes(String word) {
        if (!Utils.isStringWithQuotes(word)) {
            throw new IllegalArgumentException("Expect input with double quotes");
        }
    }
}


