package AlgoSolving;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The {@code GoodEvilSolver} class provides a solution to determine the result of a battle between Good and Evil
 * forces based on the number of units for each side and their corresponding worth.
 * Each unit type from Good and Evil is assigned a worth, and the total worth is calculated to determine the outcome.
 */
public class GoodEvilSolver {

    // Worth of each unit type for Good forces
    private static final int[] GOOD_WORTH = {1, 2, 3, 3, 4, 10};

    // Worth of each unit type for Evil forces
    private static final int[] EVIL_WORTH = {1, 2, 2, 2, 3, 5, 10};

    /**
     * Determines the outcome of the battle between Good and Evil forces.
     *
     * @param goodAmounts A string representing the number of each type of Good forces, separated by spaces.
     * @param evilAmounts A string representing the number of each type of Evil forces, separated by spaces.
     * @return A string indicating whether Good triumphs, Evil eradicates Good, or if there is no victor.
     */
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

    /**
     * Calculates the total score for a given side based on the number of units and their corresponding worth.
     *
     * @param value A string representing the number of each unit type, separated by spaces.
     * @param worth An array representing the worth of each unit type.
     * @return The total score of the side.
     */
    private static int getScore(String value, int[] worth) {
        int[] score = Arrays
                .stream(value.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return IntStream.range(0, worth.length)
                .map(i -> worth[i] * score[i])
                .sum();
    }

}
