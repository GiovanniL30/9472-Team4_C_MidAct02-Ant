package Processors;

/**
 * The {@code LeapYearChecker} class provides a utility method to determine
 * whether a given year is a leap year according to the rules of the Gregorian calendar.
 */

public class LeapYearChecker {
    /**
     * Determines if a given year is a leap year based on the rules of the Gregorian calendar.
     *
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     * @throws IllegalArgumentException if the year is not a positive integer
     */
    public static boolean isLeapYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be a positive integer.");
        }

        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;

    }
}
