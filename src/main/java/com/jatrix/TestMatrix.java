package main.java.com.jatrix;

import main.java.com.jatrix.decompositions.CholeskyDecomposition;
import main.java.com.jatrix.decompositions.LUDecomposition;
import main.java.com.jatrix.decompositions.LUPDecomposition;
import main.java.com.jatrix.solvers.CramerSolver;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix newMatrix = new Matrix(new double[][]{
                {-7.32111111, 5, -0.5555},
                {-1221.55, 2.51, -1},
                {3, 0.05555, 1}
        });

        System.out.println(newMatrix.prettyOut());
//        System.out.println(newMatrix.prettyOut());

        System.out.println((int) 9.99999999999);



    }
}
