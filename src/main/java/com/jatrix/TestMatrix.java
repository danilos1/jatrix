package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix m = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 1},
        });
        System.out.println(Matrices.inverse(m));
    }
}
