package Processors;

/**
 * The {@code StringProcessor} class provides various utility methods for processing strings.
 * This includes operations such as converting to camel case, masking characters,
 * ordering words based on digits, and finding missing letters in a character array.
 */

public class StringProcessor {

    /**
     * Converts a string to camel case by adding spaces before uppercase letters.
     *
     * @param input the input string
     * @return the camel case string
     */
    public static String camelCase(String input) {
        StringBuilder answer = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c) && answer.length() > 0) {
                answer.append(" ");
            }
            answer.append(c);
        }
        return answer.toString();
    }

    /**
     * Masks all but the last four characters of a string with '#' symbol.
     *
     * @param str the input string
     * @return the masked string
     */
    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        }

        StringBuilder masked = new StringBuilder();
        int length = str.length();

        for (int i = 0; i < length - 4; i++) {
            masked.append('#');
        }

        masked.append(str.substring(length - 4));
        return masked.toString();
    }

    /**
     * Orders words in a string based on the digits contained within each word.
     *
     * @param words the input string of words
     * @return the ordered string
     */
    public static String order(String words) {
        if (words == null || words.isEmpty()) {
            return "";
        }

        String[] tempWords = words.split("\\s+");
        String[] sortedWords = new String[tempWords.length];

        for (String currentWord : tempWords) {
            for (char c : currentWord.toCharArray()) {
                if (Character.isDigit(c)) {
                    int index = Character.getNumericValue(c) - 1;
                    if (index >= 0 && index < sortedWords.length) {
                        sortedWords[index] = currentWord;
                    }
                    break;
                }
            }
        }
        return String.join(" ", sortedWords).trim();
    }

    /**
     * Finds the missing letter in a character array.
     *
     * @param array the input character array
     * @return the missing letter or space if not found
     */
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (((int) array[i] + 1) != (int) array[i + 1]) {
                return (char) (array[i] + 1);
            }
        }
        return ' ';
    }
}
