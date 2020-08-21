package com.jatrix.core;

import com.jatrix.decompositions.LUPDecomposition;
import com.jatrix.solvers.CramerSolver;

import java.io.File;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix coefficients = new Matrix(new double[][]{
                { -5, 3, -1 },
                {  0, 8,  2 },
        });

        double[] b = {1, -5};

        CramerSolver solver = new CramerSolver(coefficients, b);
        System.out.println(solver);
    }
}
