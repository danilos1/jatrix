package main.java.com.jatrix;

import main.java.com.jatrix.decompositions.CholeskyDecomposition;
import main.java.com.jatrix.decompositions.LUDecomposition;
import main.java.com.jatrix.decompositions.LUPDecomposition;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix A = new Matrix(new double[][]{
                {5, 5, -9},
                {5, 8,  -6},
                {-9,  -6, 8},
        });;

        System.out.println(new LUPDecomposition(A).det());
        System.out.println(new LUDecomposition(A).det());
        System.out.println(new CholeskyDecomposition(A).det());
    }
}
