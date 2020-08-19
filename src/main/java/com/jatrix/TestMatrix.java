package main.java.com.jatrix;

import main.java.com.jatrix.decompositions.LUDecomposition;
import main.java.com.jatrix.solvers.CramerSolver;

import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        int N = 30;
        Matrix newMatrix = new Matrix(N);
        Matrices.fillRandom(newMatrix);

        LUDecomposition lu = new LUDecomposition(newMatrix);
        System.out.println(lu.getU().prettyOut(5));
    }
}
