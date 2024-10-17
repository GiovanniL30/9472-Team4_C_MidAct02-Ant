package Processors;

public class DateProcessor {

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

}
