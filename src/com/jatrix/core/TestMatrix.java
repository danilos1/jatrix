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
        double[][] n = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34}
        };
        Matrix m1 = new Matrix(n);
        StrassenProduct.split(m1);
    }
}
