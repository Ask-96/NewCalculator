import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        // Loop forever
        while (true) {

            final Scanner in = new Scanner(System.in);
            final String leftWord, operation, rightWord;
            leftWord = in.next();
            operation = in.next();
            rightWord = in.next();

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


