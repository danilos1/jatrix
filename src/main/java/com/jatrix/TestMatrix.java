package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;



public class TestMatrix {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {15,5,0,0,8,4,-6,3,2,1},
                {2,5,6,8,-6,12,11,10,10,-7},
                {7,8,1,-6,12,-8,7,7,6,10},
                {3,9,8,-1,-9,9,9,1,12,11},
                {1,0,0,-5,4,5,7,4,3,4},
                {15,12,-4,3,3,10,17,9,9,-1},
                {10,0,13,-5,4,5,7,4,3,8},
                {1,1,0,-15,4,5,17,4,13,4},
                {-9,12,-19,-5, -16, 15,7,4,3,4},
                {0,-9,0,-5,4,-2,17,4,13,4},
        });

        LUPDecomposition lup = new LUPDecomposition(A);
        LUDecomposition lu = new LUDecomposition(A);

        System.out.println("LU determinant: "+lu.det());
        System.out.println("LUP determinant: "+lup.det());

    }
}
