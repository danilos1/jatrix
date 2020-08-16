package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{
                {3, -0.1, -0.2},
                {0.1, 7, -0.3},
                {0.3, -0.2, 10},
        });

        LUDecomposition lu = new LUDecomposition(matrix);
        LUPDecomposition lup = new LUPDecomposition(matrix);

        System.out.println("L: \n"+lup.getL());
        System.out.println("U: \n"+lup.getU());
    }
}
