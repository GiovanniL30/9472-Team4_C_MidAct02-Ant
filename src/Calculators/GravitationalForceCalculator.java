package Calculators;

import java.util.Map;

public class GravitationalForceCalculator {

    public static final double G = 6.67 * Math.pow(10, -11);
    public static double solution(double[] arrVal, String[] arrUnit) {
        // TODO
        Map<String, Double> mass = Map.of(
                "kg", 1.0,
                "g", Math.pow(10, -3),
                "mg",Math.pow(10, -6),
                "μg", Math.pow(10, -9),
                "lb", 0.453592
        );
        Map<String, Double> distance = Map.of(
                "m", 1.0,
                "cm", Math.pow(10, -2),
                "mm", Math.pow(10, -3),
                "μm", Math.pow(10, -6),
                "ft", 0.3048
        );
        double mass1 = arrVal[0] * mass.getOrDefault(arrUnit[0].toLowerCase(),0.0);
        double mass2 = arrVal[1] * mass.getOrDefault(arrUnit[1].toLowerCase(),0.0);
        double dist = arrVal[2] * distance.getOrDefault(arrUnit[2].toLowerCase(),0.0);
        return G * mass1 * mass2 / Math.pow(dist,2);
    }

}
