package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;


public class TestMatrix {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {5, 2, 3},
                {6, 2, 6},
                {7, 8, 9},
        });

        LUPDecomposition lup = new LUPDecomposition(A);
        LUDecomposition lu = new LUDecomposition(A);

        System.out.println(lu.getU());
        System.out.println(lu.getL());
    }
}
