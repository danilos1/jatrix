package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{
                {0, 0, 2},
                {0, -1, 3},
                {2, 3, 8},
        });

        Matrix inversed = Matrices.inverse(matrix);

        System.out.println(inversed);
    }
}
