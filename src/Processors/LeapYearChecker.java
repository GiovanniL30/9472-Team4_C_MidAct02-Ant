package Processors;

public class LeapYearChecker {
    /**
     Determines if a given year is a leap year based on the rules of the Gregorian calendar
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0){
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }
}
