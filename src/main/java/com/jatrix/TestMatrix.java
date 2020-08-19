package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        double[][] m = {{1,2,3},
                        {4,5,6},
                        {-1010040214,8,125}};
        Matrix newMatrix = new Matrix(m);
        System.out.println(newMatrix.prettyOut());

    }
}
