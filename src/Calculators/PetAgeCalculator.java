package Calculators;

public class PetAgeCalculator {

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {

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

}
