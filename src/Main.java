import AlgoSolving.*;
import Calculators.*;
import Processors.*;


public class Main {
    public static void main(String[] args) {
        // GoodEvilSolver
        System.out.println(GoodEvilSolver.battle("1 1 1 1 1 1", "1 1 1 1 1 1 1"));
        // SuperMarketQueue
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
        // GravitationalForceCalculator
        System.out.println(GravitationalForceCalculator.solution(new double[]{1, 1, 1}, new String[]{"kg", "kg", "m"}));
//        // PetAgeCalculator
//        PetAgeCalculator.humanYearsCatYearsDogYears(1);
//        // DateProcessor
//        DateProcessor.getDay(5);
//        int century = 2000;
//        DateProcessor.whatCentury(century);
//        //LeapYearChecker
//        LeapYearChecker.isLeapYear(2000);
//        //NumberProcessor
    }
}
