import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solutions {

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {
        // base case
        if (humanYears == 1) return new int[]{humanYears,15,15};

        int cat = 0;
        int dog = 0;

        for (int i = 1; i <= humanYears; i++) {
            if (i == 1) {
                cat += 15;
                dog += 15;
            } else if (i == 2) {
                cat += 9;
                dog += 9;
            } else {
                cat += 4;
                dog += 5;
            }
        }

        return new int[] {humanYears, cat, dog};
    }


    public static boolean isLeapYear(int year) {
        if (year % 400 == 0){
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }

    public static int lastDigit(int[] numsArray) {
        // Base Case
        if (numsArray.length == 0) return 1;

        boolean isPreviousZero = false;
        boolean isPreviousNumGreaterThan2 = false;
        int mod4Result = 1;

        for (int i = numsArray.length - 1; i > 0; --i) {
            if (isPreviousZero) {
                mod4Result = 1;
                isPreviousZero = false;
                isPreviousNumGreaterThan2 = false;
            } else {
                mod4Result = (isPreviousNumGreaterThan2 && (numsArray[i] % 4 == 2)) ? 0 : trueModulo(numsArray[i], mod4Result, 4);
                isPreviousZero = numsArray[i] == 0;
                isPreviousNumGreaterThan2 = !isPreviousZero && !(numsArray[i] == 1);
            }
        }
        return isPreviousZero ? 1 : trueModulo(numsArray[0], mod4Result, 10);
    }


    // Helper method applying modular arithmetic
    public static int trueModulo(int base, int exp, int mod) {
        int baseModulus = base % mod;
        int exponent = (exp + 3) % 4;
        return (int) Math.round(baseModulus * Math.pow(baseModulus, exponent)) % mod;
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>();

        // initialize all counters
        for (int i = 0; i < n; i++) {
            queue.add(0); // set all counter's time to 0
        }

        // loop until all customer's time is processed
        for (int time: customers) {
            int minimumTime = queue.poll();
            queue.add(minimumTime + time);
        }

        int max = 0;
        while (!queue.isEmpty()) {
            max = Math.max(max, queue.poll());
        }

        return max;
    }

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

    public static String highAndLow(String numbers) {
        // Code here or
        String [] nums = numbers.split(" ");
        int min = Integer.valueOf(nums[0]);
        int max = min;

        for(String number : nums ){
            int currentNum = Integer.valueOf(number);

            if(min > currentNum) min = currentNum;
            if(max < currentNum) max = currentNum;
        }

        return max + " " + min;
    }

    public static int sequenceSum(int start, int end, int step) {
        // base case
        if (start > end) return 0;

        int sum = start;
        for (int i = start; i < end ; i += step) {
            if ((i + step) > end) {
                break;
            }
            sum += i + step;
        }
        return sum;
    }

    private static final Map<String, Integer> numbers = new HashMap<>();

    static {
        numbers.put("zero" , 0);
        numbers.put("one" , 1);
        numbers.put("two" , 2);
        numbers.put("three" , 3);
        numbers.put("four" , 4);
        numbers.put("five" , 5);
        numbers.put("six" , 6);
        numbers.put("seven" , 7);
        numbers.put("eight" , 8);
        numbers.put("nine" , 9);
        numbers.put("eleven" , 11);
        numbers.put("twelve" , 12);
        numbers.put("thirteen" , 13);
        numbers.put("fourteen" , 14);
        numbers.put("fifteen" , 15);
        numbers.put("sixteen" , 16);
        numbers.put("seventeen" , 17);
        numbers.put("eighteen" , 18);
        numbers.put("nineteen" , 19);

        numbers.put("ten" , 10);
        numbers.put("twenty" , 20);
        numbers.put("thirty" , 30);
        numbers.put("forty" , 40);
        numbers.put("fifty" , 50);
        numbers.put("sixty" , 60);
        numbers.put("seventy" , 70);
        numbers.put("eighty" , 80);
        numbers.put("ninety" , 90);

        numbers.put("hundred" , 100);
        numbers.put("thousand" , 1000);
        numbers.put("million" , 1000000);
    }



    public static int parseInt(String numStr) {
        String[] nums = numStr.replaceAll(" and", "").split("[ -]");
        int result = 0, currentValue = 0;




        for (String index: nums) {
            if (numbers.containsKey(index)) {
                int mapValue = numbers.get(index);


                if (mapValue == 100) {
                    currentValue *= mapValue;
                } else if (mapValue >= 1000) {
                    currentValue *= mapValue;
                    result += currentValue;
                    currentValue = 0;
                } else {
                    currentValue += mapValue;
                }

            }
        }
        // Your code here!
        return result + currentValue;
    }

    public static final double G = 6.67 * Math.pow(10, -11);
    public static double solution(double[] arrVal, String[] arrUnit) {
        // TODO
        Map<String, Double> mass = Map.of(
                "kg", 1.0,
                "g", Math.pow(10, -3),
                "mg",Math.pow(10, -6),
                "μg", Math.pow(10, -9),
                "lb", 0.453592
        );
        Map<String, Double> distance = Map.of(
                "m", 1.0,
                "cm", Math.pow(10, -2),
                "mm", Math.pow(10, -3),
                "μm", Math.pow(10, -6),
                "ft", 0.3048
        );
        double mass1 = arrVal[0] * mass.getOrDefault(arrUnit[0].toLowerCase(),0.0);
        double mass2 = arrVal[1] * mass.getOrDefault(arrUnit[1].toLowerCase(),0.0);
        double dist = arrVal[2] * distance.getOrDefault(arrUnit[2].toLowerCase(),0.0);
        return G * mass1 * mass2 / Math.pow(dist,2);
    }

    public static String getDay(int n) {
        java.util.Map<Integer, String> map = new java.util.HashMap<>();
        map.put(1, "Sunday");
        map.put(2, "Monday");
        map.put(3, "Tuesday");
        map.put(4, "Wednesday");
        map.put(5, "Thursday");
        map.put(6, "Friday");
        map.put(7, "Saturday");

        return map.getOrDefault(n, "Wrong, please enter a number between 1 and 7");
    }



    public static String whatCentury(int year) {
        // coding here
        int century = (year + 99) / 100;

        if(century >= 11 && century <= 13 ){
            return century + "th";
        }

        return switch(century % 10) {
            case 1 -> century + "st";
            case 2 -> century + "nd";
            case 3 -> century + "rd";
            default -> century + "th";
        };

    }

    public static long[] productFib(long prod) {
        long firstSeq = 0, secondSeq = 1, nextSeq;

        while (firstSeq * secondSeq < prod) {
            nextSeq = firstSeq + secondSeq;
            firstSeq = secondSeq;
            secondSeq = nextSeq;
        }

        return new long[]{firstSeq, secondSeq, firstSeq * secondSeq == prod ? 1 : 0};

    }

    public static String battle(String goodAmounts, String evilAmounts) {
        int goodTotal = getScore(goodAmounts, GOOD_WORTH);
        int badTotal = getScore(evilAmounts, EVIL_WORTH);

        if (goodTotal > badTotal) {
            return "Battle Result: Good triumphs over Evil";
        } else if (badTotal > goodTotal) {
            return "Battle Result: Evil eradicates all trace of Good";
        }

        return "Battle Result: No victor on this battle field";
    }

    private static int getScore(String value, int[] worth) {
        int[] score = Arrays
                .stream(value.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return IntStream.range(0, worth.length)
                .map(i -> worth[i] * score[i])
                .sum();
    }

    private static final int[] GOOD_WORTH = {1, 2, 3, 3, 4, 10};
    private static final int[] EVIL_WORTH = {1, 2, 2, 2, 3, 5, 10};

    public static String camelCase(String input) {

        String answer = "";
        for(char c : input.toCharArray()) {
            answer += Character.isUpperCase(c) ? " " + c : c;
        }
        return answer;
    }

    public static int sequence(int[] arr) {

        // using Kadane's Algorithm

        int max = 0;
        int total = 0;

        for(int current : arr) {
            total += current;
            max = Math.max(max, total);
            total = total < 0 ? 0 : total;
        }

        return max;
    }

    public static void makeMeSlow() {
        try {
            Thread.sleep(7000);
        }catch(Exception ex) {
        }
    }

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

    public static String binaryAddition(int a, int b){

        int sum = a + b;

        StringBuilder answer = new StringBuilder("");

        while( sum != 0) {
            answer.append(sum % 2);
            sum /= 2;
        }


        return answer.reverse().toString();
    }

    public static int digital_root(int n) {

        if(n < 10) return n;

        int temp = n;
        int total = 0;

        while( temp != 0) {
            total += temp % 10;
            temp = temp / 10;
        }

        return digital_root(total);

    }

    public static char findMissingLetter(char[] array){

        for(int i = 0; i < array.length; i++) {

            if(  ((int)array[i] + 1 ) != ( (int) array[i + 1]) ) {
                return (char) (array[i + 1] - 1);
            }

        }

        return ' ';
    }

    public static double findUniq(double[] arr) {

        if (arr[0] != arr[1]) {

            if (arr[0] != arr[2]) {
                return arr[0];
            } else {
                return arr[1];
            }

        }

        double commonValue = arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != commonValue) {
                return arr[i];
            }
        }

        throw new IllegalArgumentException("Array does not contain exactly one unique element.");
    }




}
