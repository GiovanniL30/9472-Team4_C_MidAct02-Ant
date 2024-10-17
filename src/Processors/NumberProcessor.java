package Processors;

import java.util.HashMap;
import java.util.Map;

public class NumberProcessor {

    private static final Map<String, Integer> numbers = new HashMap<>();


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
            } else {
                mod4Result = (isPreviousNumGreaterThan2 && (numsArray[i] % 4 == 2)) ? 0 : trueModulo(numsArray[i], mod4Result, 4);
                isPreviousZero = numsArray[i] == 0;
                isPreviousNumGreaterThan2 = !isPreviousZero && !(numsArray[i] == 1);
            }
        }
        return isPreviousZero ? 1 : trueModulo(numsArray[0], mod4Result, 10);
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

    public static String highAndLow(String numbers) {
        // Code here or
        String [] nums = numbers.split(" ");
        int min = Integer.parseInt(nums[0]);
        int max = min;

        for(String number : nums ){
            int currentNum = Integer.parseInt(number);

            if(min > currentNum) min = currentNum;
            if(max < currentNum) max = currentNum;
        }

        return max + " " + min;
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

    public static int parseInt(String numStr) {
        populateMap();
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

    private static void populateMap() {
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

    private static int trueModulo(int base, int exp, int mod) {
        int baseModulus = base % mod;
        int exponent = (exp + 3) % 4;
        return (int) Math.round(baseModulus * Math.pow(baseModulus, exponent)) % mod;
    }
}
