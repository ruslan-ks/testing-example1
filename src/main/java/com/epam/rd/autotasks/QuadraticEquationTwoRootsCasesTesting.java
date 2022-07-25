package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    private final double a;
    private final double b;
    private final double c;
    private final String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0}, {1}, {2} | {3}")
    public static Collection<Object[]> coefficients() {
        final String delimiter = QuadraticEquation.VALUE_DELIMITER;
        return List.of(new Object[][]{
                {1, 5, 6, "-2" + delimiter + "-3"},
                {1, 2, -15, "-5" + delimiter + "3"},
                {1, -3, 2, "1" + delimiter + "2"},
                {1, 7, 12, "-3" + delimiter + "-4"}
        });
    }

    @Test
    public void testTwoRootsCases() {
        final String delimiter = QuadraticEquation.VALUE_DELIMITER;
        final String actualString = quadraticEquation.solve(a, b, c);
        assertTrue(actualString.contains(delimiter));
        assertNotEquals(QuadraticEquation.NO_ROOTS, actualString);
        assertTrue(isNumericValuesString(actualString, delimiter));

        final String[] actualStrings = actualString.split(delimiter);
        final String[] expectedStrings = expected.split(delimiter);
        final List<Double> actualDoubles = formatDoubles(actualStrings);
        final List<Double> expectedDoubles = formatDoubles(expectedStrings);
        Collections.sort(actualDoubles);
        Collections.sort(expectedDoubles);
        assertEquals(expectedDoubles, actualDoubles);
    }

    private static List<Double> formatDoubles(String[] stringDoubleValues) {
        return Arrays.stream(stringDoubleValues)
                .map(s -> String.format("%.3f", Double.valueOf(s)))
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }

    private static boolean isNumericValuesString(String str, String delimiter) {
        if(str == null || str.isEmpty() || str.isBlank()) {
            return false;
        }
        final String[] arr = str.split(delimiter);
        if(arr.length == 0) {
            return false;
        }
        for(String piece : arr) {
            try {
                Double.parseDouble(piece);
            } catch(NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}
