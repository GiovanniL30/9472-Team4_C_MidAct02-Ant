package Calculators;

/**
 * The {@code PetAgeCalculator} class provides a method to calculate the equivalent cat and dog years
 * based on a given number of human years.
 *
 * The conversion follows a common rule:
 *     For the first year, both cats and dogs age 15 years.
 *     For the second year, both cats and dogs age 9 years.
 *     From the third year onward, cats age 4 years per human year, and dogs age 5 years per human year.
 */
public class PetAgeCalculator {

    /**
     * Converts human years to cat years and dog years.
     *
     * @param humanYears The number of human years.
     * @return An array where:
     *             Index 0 is the given human years.
     *             Index 1 is the equivalent cat years.
     *             Index 2 is the equivalent dog years.
     */
    public static int[] humanYearsCatYearsDogYears(final int humanYears) {

        // If human years is 1, return the fixed conversion for both cat and dog.
        if (humanYears == 1) return new int[]{humanYears, 15, 15};

        int cat = 0;
        int dog = 0;

        // Calculate the equivalent cat and dog years.
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

}
