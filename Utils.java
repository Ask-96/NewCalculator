package simple_calc;

public class Utils {

    /**
     * Check that word is surrounded by double quotes.
     */
    static boolean isStringWithQuotes(String word) {
        return '"' == word.charAt(0) && '"' == word.charAt(word.length() - 1);
    }

    static String removeFirstCharacter(String word) {
        return word.substring(1);
    }

    static String removeLastCharacter(String word) {
        return word.substring(0, word.length() - 1);
    }

    static String removeAll(String word, String subStr) {
        return word.replaceAll(subStr, "");
    }
}
