package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][] {
                {0, 1, 2},
                {1, 2, 1},
                {2, 7, 8}
        });

        Matrix matrix1 = Matrices.inverse(matrix);
        System.out.println(matrix1);

    }
}
