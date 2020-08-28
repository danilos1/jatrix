package com.jatrix.core;

import com.jatrix.conversion.MatrixConversion;
import com.jatrix.decompositions.CholeskyDecomposition;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.decompositions.LUPDecomposition;
import com.jatrix.solvers.CramerSolver;
import com.jatrix.solvers.GaussSolver;
import com.jatrix.statistics.MatrixStats;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix xCoefficients = new Matrix(new double[][]{{-3, 2, -1}, {-4, 3, -1}, {4, -3, 1}});
        double[] constants = {3, 4, 5};

        // Act
        CramerSolver cramerSolver = new CramerSolver(xCoefficients, constants);
        double[] roots = cramerSolver.getRoots();
    }
}
