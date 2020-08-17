package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        double[][] n = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        Matrix m1 = new Matrix(n);
        double x = Search.maxColumns(m1, 0);
        System.out.println(x);
        double y = Search.maxRows(m1, 2);
        System.out.println(y);

    }
}
