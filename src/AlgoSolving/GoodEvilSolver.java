package AlgoSolving;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GoodEvilSolver {

    private static final int[] GOOD_WORTH = {1, 2, 3, 3, 4, 10};
    private static final int[] EVIL_WORTH = {1, 2, 2, 2, 3, 5, 10};

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

}
