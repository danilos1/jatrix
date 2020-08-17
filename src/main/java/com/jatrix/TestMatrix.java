package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{
                {0, 0, 9},
                {9, 3, 0},
                {5, 8, 0},
        });

        Matrix inversed = Matrices.inverse(matrix);

        System.out.println(inversed);
    }
}
