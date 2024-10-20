package Processors;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code NumberProcessor} class provides various utility methods for numerical operations.
 * This includes operations such as finding the last digit of a sequence, summing a range of numbers,
 * identifying the highest and lowest values in a series, and processing strings that represent numbers.
 */

public class NumberProcessor {

    private static final Map<String, Integer> numbers = new HashMap<>();

    /**
     * Returns the last digit of the result of an array of numbers using modulo arithmetic.
     *
     * @param numsArray the input array of integers
     * @return the last digit or 1 if the array is empty
     */
    public static int lastDigit(int[] numsArray) {
        if (numsArray.length == 0) return 1;

        boolean isPreviousZero = false;
        boolean isPreviousNumGreaterThan2 = false;
        int mod4Result = 1;

        for (int i = numsArray.length - 1; i >= 0; --i) {
            if (isPreviousZero) {
                mod4Result = 1;
                isPreviousZero = false;
            } else {
                mod4Result = (isPreviousNumGreaterThan2 && (numsArray[i] % 4 == 2)) ? 0 : trueModulo(numsArray[i], mod4Result, 4);
                isPreviousZero = numsArray[i] == 0;
                isPreviousNumGreaterThan2 = !isPreviousZero && numsArray[i] > 1;
            }
        }
        return isPreviousZero ? 1 : trueModulo(numsArray[0], mod4Result, 10);
    }

    /**
     * Returns the sum of numbers in a sequence from start to end with a given step.
     *
     * @param start the starting number
     * @param end   the ending number
     * @param step  the step increment
     * @return the sum of the sequence
     */
    public static int sequenceSum(int start, int end, int step) {
        if (start > end) return 0;

        int sum = 0;
        for (int i = start; i <= end; i += step) {
            sum += i;
        }
        return sum;
    }

    /**
     * Returns the highest and lowest numbers in a string of space-separated numbers.
     *
     * @param numbers the space-separated string of numbers
     * @return a string containing the maximum and minimum numbers
     */
    public static String highAndLow(String numbers) {
        String[] nums = numbers.split(" ");
        int min = Integer.parseInt(nums[0]);
        int max = min;

        for (String number : nums) {
            int currentNum = Integer.parseInt(number);
            if (min > currentNum) min = currentNum;
            if (max < currentNum) max = currentNum;
        }

        return max + " " + min;
    }

    /**
     * Returns an array containing two Fibonacci numbers whose product is closest to the given product.
     *
     * @param prod the target product
     * @return an array containing the two Fibonacci numbers and an indicator if their product equals the target
     */
    public static long[] productFib(long prod) {
        long firstSeq = 0, secondSeq = 1, nextSeq;

        while (firstSeq * secondSeq < prod) {
            nextSeq = firstSeq + secondSeq;
            firstSeq = secondSeq;
            secondSeq = nextSeq;
        }
        return new long[]{firstSeq, secondSeq, firstSeq * secondSeq == prod ? 1 : 0};
    }

    /**
     * Returns the maximum sum of a consecutive subsequence in the given array.
     *
     * @param arr the input array
     * @return the maximum sum of a consecutive subsequence
     */
    public static int sequence(int[] arr) {
        int max = 0, total = 0;

        for (int current : arr) {
            total += current;
            max = Math.max(max, total);
            total = Math.max(total, 0); // Reset total if it's negative
        }

        return max;
    }

    /**
     * Returns the sum of two integers as a binary string.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the binary representation of the sum
     */
    public static String binaryAddition(int a, int b) {
        int sum = a + b;
        return Integer.toBinaryString(sum); // Simplified conversion to binary string
    }

    /**
     * Returns the digital root of a given number (sum of digits until a single digit is obtained).
     *
     * @param n the input number
     * @return the digital root
     */
    public static int digital_root(int n) {
        return (n - 1) % 9 + 1; // Efficient way to calculate digital root
    }

    /**
     * Returns the unique number in an array where all other numbers are the same.
     *
     * @param arr the input array
     * @return the unique number
     * @throws IllegalArgumentException if the array does not contain exactly one unique element
     */
    public static double findUniq(double[] arr) {
        if (arr.length < 3) {
            throw new IllegalArgumentException("Array must contain at least three elements.");
        }

        // Check the first three elements to find the unique one
        if (arr[0] != arr[1]) {
            return arr[0] != arr[2] ? arr[0] : arr[1];
        }

        double commonValue = arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != commonValue) {
                return arr[i];
            }
        }
        throw new IllegalArgumentException("Array does not contain exactly one unique element.");
    }

    /**
     * Parses a number string into an integer (e.g., "one hundred twenty-three" -> 123).
     *
     * @param numStr the input number string
     * @return the integer representation of the number
     */
    public static int parseInt(String numStr) {
        populateMap();
        String[] nums = numStr.replaceAll(" and", "").split("[ -]");
        int result = 0, currentValue = 0;

        for (String index : nums) {
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
        return result + currentValue;
    }

    /**
     * Populates a map with number words and their corresponding integer values.
     */
    private static void populateMap() {
        if (numbers.isEmpty()) { // Prevents repopulating the map
            numbers.put("zero", 0);
            numbers.put("one", 1);
            numbers.put("two", 2);
            numbers.put("three", 3);
            numbers.put("four", 4);
            numbers.put("five", 5);
            numbers.put("six", 6);
            numbers.put("seven", 7);
            numbers.put("eight", 8);
            numbers.put("nine", 9);
            numbers.put("ten", 10);
            numbers.put("eleven", 11);
            numbers.put("twelve", 12);
            numbers.put("thirteen", 13);
            numbers.put("fourteen", 14);
            numbers.put("fifteen", 15);
            numbers.put("sixteen", 16);
            numbers.put("seventeen", 17);
            numbers.put("eighteen", 18);
            numbers.put("nineteen", 19);
            numbers.put("twenty", 20);
            numbers.put("thirty", 30);
            numbers.put("forty", 40);
            numbers.put("fifty", 50);
            numbers.put("sixty", 60);
            numbers.put("seventy", 70);
            numbers.put("eighty", 80);
            numbers.put("ninety", 90);
            numbers.put("hundred", 100);
            numbers.put("thousand", 1000);
            numbers.put("million", 1000000);
        }
    }

    // Computes the correct modulo of a number based on exponentiation rules
    private static int trueModulo(int base, int exp, int mod) {
        int baseModulus = base % mod;
        int exponent = (exp + 3) % 4;
        return (int) Math.round(baseModulus * Math.pow(baseModulus, exponent)) % mod;
    }
}
