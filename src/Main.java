import AlgoSolving.*;
import Calculators.*;
import Processors.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
         runGoodEvilSolver();
         runSuperMarketQueue();
         runGravitationalForceCalculator();
         runPetAgeCalculator();
         runDateProcessor();
         runLeapYearChecker();
         runLastDigit();
         runSequenceSum();
         runHighAndLow();
         runProductFib();
         runBinaryAddition();
         runDigitalRoot();
         runFindUniq();
         runCamelCase();
         runMaskify();
         runOrder();
         runFindMissingLetter();
    }

    /**
     * Demonstrates the Good vs Evil battle score calculation.
     * It prints the amounts of good and evil characters and the result of the battle.
     */
    private static void runGoodEvilSolver() {
        String goodAmounts = "1 2 3 4 5 6";
        String evilAmounts = "1 1 2 2 2 2 1";

        System.out.println("\nGood Evil Solver:");
        System.out.println("Good Amounts: " + goodAmounts);
        System.out.println("Evil Amounts: " + evilAmounts);
        System.out.println(GoodEvilSolver.battle(goodAmounts, evilAmounts));
    }

    /**
     * Simulates a supermarket queue to calculate total time taken for customers to checkout.
     */
    private static void runSuperMarketQueue() {
        System.out.println("\nSuper Market Queue:");
        int[] data = new int[]{2, 2, 3, 3, 4, 4};
        int totalCounters = 2;
        System.out.println("Customer Time: " + Arrays.toString(data));
        System.out.println("Total Counter/s: " + totalCounters);

        System.out.println("Total Time: " + SuperMarketQueue.solveSuperMarketQueue(data, totalCounters));
    }

    /**
     * Calculates the gravitational force between two masses (Earth and Moon).
     */
    private static void runGravitationalForceCalculator() {
        System.out.println("\nGravitational Force Calculator:");

        double[] arrVal = {5.972 * Math.pow(10, 24), 7.348 * Math.pow(10, 22), 384400000};
        String[] arrUnit = {"kg", "kg", "m"};

        System.out.println("Mass 1 (Earth): " + arrVal[0] + " " + arrUnit[0]);
        System.out.println("Mass 2 (Moon): " + arrVal[1] + " " + arrUnit[1]);
        System.out.println("Distance: " + arrVal[2] + " " + arrUnit[2]);

        double force = GravitationalForceCalculator.solution(arrVal, arrUnit);
        System.out.println("Gravitational Force: " + force + " N");
    }

    /**
     * Converts human years into equivalent cat and dog years.
     */
    private static void runPetAgeCalculator() {
        System.out.println("\nPet Age Calculator:");

        int humanYears = 5;

        int[] ages = PetAgeCalculator.humanYearsCatYearsDogYears(humanYears);

        System.out.println("Human Years: " + ages[0]);
        System.out.println("Cat Years: " + ages[1]);
        System.out.println("Dog Years: " + ages[2]);
    }

    /**
     * Provides functionality to get the name of the day based on a number and to find the century of a year.
     */
    private static void runDateProcessor() {
        System.out.println("\nDate Processor:");

        int dayNumber = 3;
        System.out.println("Day for number " + dayNumber + ": " + DateProcessor.getDay(dayNumber));

        int year = 2023;
        System.out.println("Century for year " + year + ": " + DateProcessor.whatCentury(year));
    }

    /**
     * Checks if given years are leap years or not.
     */
    private static void runLeapYearChecker() {
        System.out.println("\nLeap Year Checker:");

        int[] years = {2020, 2023, 1900, 2000};

        for (int year : years) {
            boolean isLeap = LeapYearChecker.isLeapYear(year);
            System.out.println("Year " + year + " is a leap year: " + isLeap);
        }
    }

    /**
     * Computes the last digit of the product of an array of integers.
     */
    private static void runLastDigit() {
        System.out.println("\nLast Digit of Array Product:");
        int[] numsArray = {12, 30, 25};
        System.out.println("Input: " + Arrays.toString(numsArray));
        System.out.println("Last Digit: " + NumberProcessor.lastDigit(numsArray));
    }

    /**
     * Calculates the sum of a sequence based on start, end, and step values.
     */
    private static void runSequenceSum() {
        System.out.println("\nSequence Sum:");
        int start = 2, end = 10, step = 2;
        System.out.println("Input: Start=" + start + ", End=" + end + ", Step=" + step);
        System.out.println("Sum: " + NumberProcessor.sequenceSum(start, end, step));
    }

    /**
     * Finds the highest and lowest numbers in a space-separated string of integers.
     */
    private static void runHighAndLow() {
        System.out.println("\nHigh and Low:");
        String numbers = "1 2 3 4 5 6 -1 0";
        System.out.println("Input: " + numbers);
        System.out.println("Output: " + NumberProcessor.highAndLow(numbers));
    }

    /**
     * Finds two consecutive Fibonacci numbers that yield a product closest to a given number.
     */
    private static void runProductFib() {
        System.out.println("\nProduct of Fibonacci Numbers:");
        long prod = 4895;
        System.out.println("Input: " + prod);
        long[] result = NumberProcessor.productFib(prod);
        System.out.println("Output: [" + result[0] + ", " + result[1] + ", " + result[2] + "]");
    }

    /**
     * Adds two integers and returns the binary representation of the result.
     */
    private static void runBinaryAddition() {
        System.out.println("\nBinary Addition:");
        int a = 5, b = 9;
        System.out.println("Input: " + a + " + " + b);
        System.out.println("Binary Output: " + NumberProcessor.binaryAddition(a, b));
    }

    /**
     * Calculates the digital root of a number.
     */
    private static void runDigitalRoot() {
        System.out.println("\nDigital Root:");
        int n = 493193;
        System.out.println("Input: " + n);
        System.out.println("Output: " + NumberProcessor.digital_root(n));
    }

    /**
     * Finds the unique number in an array where all others are the same.
     */
    private static void runFindUniq() {
        System.out.println("\nFind Unique Number:");
        double[] arr = {1, 1, 1, 2, 1, 1};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Unique Number: " + NumberProcessor.findUniq(arr));
    }

    /**
     * Splits a camelCase string into separate words.
     */
    private static void runCamelCase() {
        System.out.println("\nCamel Case Split:");
        String input = "camelCaseExample";
        System.out.println("Input: " + input);
        System.out.println("Output: " + StringProcessor.camelCase(input));
    }

    /**
     * Masks all but the last four characters of a string with '#'.
     */
    private static void runMaskify() {
        System.out.println("\nMaskify:");
        String str = "4556364607935616";
        System.out.println("Input: " + str);
        System.out.println("Masked Output: " + StringProcessor.maskify(str));
    }

    /**
     * Orders words in a sentence based on the number they contain.
     */
    private static void runOrder() {
        System.out.println("\nOrder Words by Number:");
        String sentence = "is2 Thi1s T4est 3a";
        System.out.println("Input: " + sentence);
        System.out.println("Ordered Output: " + StringProcessor.order(sentence));
    }

    /**
     * Finds a missing letter in a given character array.
     */
    private static void runFindMissingLetter() {
        System.out.println("\nFind Missing Letter:");
        char[] letters = {'a', 'b', 'c', 'e'};
        System.out.println("Input: " + Arrays.toString(letters));
        System.out.println("Missing Letter: " + StringProcessor.findMissingLetter(letters));
    }
}
