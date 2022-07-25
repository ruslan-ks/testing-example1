package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class QuadraticEquationZeroACasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquationZeroACasesTesting(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters(name = "{0}, {1}, {2}")
    public static Collection<Object[]> coefficients() {
        return List.of(new Object[][]{
                {0, 1, 2},
                {0, -1, -2},
                {0, 555, 777},
                {0, -1000, 200}
        });
    }


    @Test(expected = IllegalArgumentException.class)
    public void testZeroACases() {
        quadraticEquation.solve(a, b, c);
    }
}
