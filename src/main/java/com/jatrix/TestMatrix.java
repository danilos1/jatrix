package main.java.com.jatrix;

import main.java.com.jatrix.decomposition.CholeskyDecomposition;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import java.util.Arrays;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(6);
        Matrices.fillRandom(matrix);
        System.out.println(matrix.prettyOut());

        System.out.println("numbers of -3: "+matrix.stream().filter(x -> x == -3).count());

    }
}
