package main.java.com.jatrix;

import main.java.com.jatrix.decompositions.CholeskyDecomposition;
import main.java.com.jatrix.decompositions.LUDecomposition;
import main.java.com.jatrix.decompositions.LUPDecomposition;
import main.java.com.jatrix.solvers.CramerSolver;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {12, 3, 15},
                {2, -3, -4},
                {11, -3.4, 5.7},
        });;

        CramerSolver solver = new CramerSolver(A, new double[]{13, 0.5, -6});
        System.out.println(solver);
    }
}
