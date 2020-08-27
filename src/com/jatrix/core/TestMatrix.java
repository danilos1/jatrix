package com.jatrix.core;

import com.jatrix.decompositions.CholeskyDecomposition;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.decompositions.LUPDecomposition;
import com.jatrix.solvers.CramerSolver;
import com.jatrix.solvers.GaussSolver;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestMatrix {
    public static void main(String[] args) {
        double[] constants = new double[]{9,3,2};
        CramerSolver solver = new CramerSolver(
                new Matrix(new double[][]{{1,1,-1},{0,1,3},{-1,0,-2}}),
                constants
        );
        System.out.println(Arrays.toString(constants));
        System.out.println(solver);


        GaussSolver gaussSolver = new GaussSolver(new Matrix(new double[][]{{1,1,-1},{0,0,7},{0,0,-2}}),
                constants);
        System.out.println(gaussSolver);
    }
}
