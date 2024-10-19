package Processors;

public class StringProcessor {

    /**
     Converts a string to camel case by adding spaces before uppercase letters
     */
    public static String camelCase(String input) {
        String answer = "";
        for(char c : input.toCharArray()) {
            answer += Character.isUpperCase(c) ? " " + c : c;
        }
        return answer;
    }

    /**
     Masks all but the last four characters of a string with '#' symbol
     */
    public static String maskify(String str) {
        if (str.length() > 4) {
            int wordLength = str.length() - 4;
            StringBuilder sb = new StringBuilder(str);
            String reversed = sb.reverse().toString();

            String lastFour = reversed.substring(0,4);
            StringBuilder sb2 = new StringBuilder(lastFour);

            String lastLastFour = sb2.reverse().toString();
            String blank = "";

            for (int i = 0; i < wordLength; i++) {
                blank += "#";
            }

            return blank + lastLastFour;
        }

        return str;
    }

    /**
     Orders words in a string based on the digits contained within each word
     */
    public static String order(String words) {
        if (words == null || words.isEmpty()) {
            return "";
        }

        String[] tempWords = words.split("\\s");
        String[] sortedWords = new String[tempWords.length];

        for (String currentWord : tempWords) {

            for (char c : currentWord.toCharArray()) {
                if (Character.isDigit(c)) {
                    sortedWords[Character.getNumericValue(c) - 1] = currentWord;
                    break;
                }
            }
        }
        return String.join(" ", sortedWords);
    }

    /**
     Finds the missing letter in a character array
     */
    public static char findMissingLetter(char[] array){
        for(int i = 0; i < array.length; i++) {

            if(  ((int)array[i] + 1 ) != ( (int) array[i + 1]) ) {
                return (char) (array[i + 1] - 1);
            }
        }
        return ' ';
    }

}
