package com.epam.rd.autotasks;

public class QuadraticEquation {
    public static final String VALUE_DELIMITER = " ";
    public static final String NO_ROOTS = "no roots";

    public String solve(double a, double b, double c) {
        if(a == 0) {
            throw new IllegalArgumentException();
        }
        final double D = b * b - 4 * a * c;
        if(D == 0) {
            final double x = -b / (2 * a);
            return String.valueOf(x);
        } else if(D > 0) {
            final double x1 = (-b + Math.sqrt(D)) / (2 * a);
            final double x2 = (-b - Math.sqrt(D)) / (2 * a);
            return x1 + VALUE_DELIMITER + x2;
        }
        return NO_ROOTS;
    }

}