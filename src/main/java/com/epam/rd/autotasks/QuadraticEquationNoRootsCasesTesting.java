package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationNoRootsCasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    private final double a;
    private final double b;
    private final double c;

    @Parameterized.Parameters(name = "{0}, {1}, {2}")
    public static Collection<Object[]> coefficients() {
        System.out.println("Obtaining parameters...");
        return List.of(new Object[][]{
                {1, -3, 4},
                {2, 4, 4},
                {3, 5, 3},
                {-1, 3, -3}
        });
    }

    public QuadraticEquationNoRootsCasesTesting(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Test
    public void testNoRootsCase() {
        assertEquals(QuadraticEquation.NO_ROOTS, quadraticEquation.solve(a, b, c));
    }
}
