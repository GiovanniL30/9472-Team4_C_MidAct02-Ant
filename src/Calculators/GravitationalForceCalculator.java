package Calculators;

import java.util.Map;

/**
 * The {@code GravitationalForceCalculator} class calculates the gravitational force between two masses
 * using Newton's law of universal gravitation.
 * It supports different units for mass (kg, g, mg, μg, lb) and distance (m, cm, mm, μm, ft),
 * automatically converting them into SI units before performing the calculation.
 */
public class GravitationalForceCalculator {

    /**
     * The gravitational constant (G) in N⋅m²/kg².
     */
    public static final double G = 6.67 * Math.pow(10, -11);

    /**
     * Calculates the gravitational force between two masses given their values, units, and distance.
     *
     * @param arrVal  An array containing the values of mass1, mass2, and distance.
     *                {@code arrVal[0]} is the first mass, {@code arrVal[1]} is the second mass, and {@code arrVal[2]} is the distance.
     * @param arrUnit An array containing the units corresponding to the values in {@code arrVal}.
     *                The first two values should be mass units (e.g., "kg", "g"), and the third value should be a distance unit (e.g., "m", "cm").
     * @return The gravitational force between the two masses in Newtons (N).
     */
    public static double solution(double[] arrVal, String[] arrUnit) {
        // Map for converting mass units to kilograms
        Map<String, Double> mass = Map.of(
                "kg", 1.0,
                "g", Math.pow(10, -3),
                "mg", Math.pow(10, -6),
                "μg", Math.pow(10, -9),
                "lb", 0.453592
        );

        // Map for converting distance units to meters
        Map<String, Double> distance = Map.of(
                "m", 1.0,
                "cm", Math.pow(10, -2),
                "mm", Math.pow(10, -3),
                "μm", Math.pow(10, -6),
                "ft", 0.3048
        );

        // Convert masses and distance to SI units
        double mass1 = arrVal[0] * mass.getOrDefault(arrUnit[0].toLowerCase(), 0.0);
        double mass2 = arrVal[1] * mass.getOrDefault(arrUnit[1].toLowerCase(), 0.0);
        double dist = arrVal[2] * distance.getOrDefault(arrUnit[2].toLowerCase(), 0.0);

        // Calculate the gravitational force using Newton's law of universal gravitation
        return G * mass1 * mass2 / Math.pow(dist, 2);
    }

}
