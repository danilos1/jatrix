package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{
                {534, 12, -155},
                {12, 1524, -43},
                {-155, -43, 98},
        });
        LUDecomposition lu = new LUDecomposition(matrix);
        CholeskyDecomposition cd = new CholeskyDecomposition(matrix);

        System.out.println(lu.det());
        System.out.println(cd.det());
    }
}
