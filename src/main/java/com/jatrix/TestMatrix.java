package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {6,10,3},
                {3,5,6},
                {7,8,1},
        });

        LUPDecomposition lup = new LUPDecomposition(A);

        System.out.println("P: \n"+lup.getP());
        System.out.println("L: \n"+lup.getL());
        System.out.println("U: \n"+lup.getU());

        System.out.println(lup.det());

    }
}
