package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {0,2,3, 12, 7},
                {17,2,3, 23, -5},
                {0,31,-39, 6, 3},
                {4,-12,10, -5, -5},
                {7,8,1, 0, 9},
        });

        LUPDecomposition lup = new LUPDecomposition(A);

        System.out.println("P: \n"+lup.getP());
        System.out.println("L: \n"+lup.getL());
        System.out.println("U: \n"+lup.getU());

        System.out.println(lup.det());

    }
}
