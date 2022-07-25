package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationSingleRootCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    private final double a;
    private final double b;
    private final double c;
    private final double expected;

    public QuadraticEquationSingleRootCasesTesting(double a, double b, double c, double expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0}, {1}, {2} | {3}")
    public static Collection<Object[]> coefficients() {
        return List.of(new Object[][]{
                {1, 4, 4, -2},
                {2, 4, 2, -1},
                {-2, 8, -8, 2},
                {-5, 10, -5, 1}
        });
    }

    @Test
    public void testTwoRootsCases() {
        assertEquals(String.valueOf(expected), quadraticEquation.solve(a, b, c));
    }

}