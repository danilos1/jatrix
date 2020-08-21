package com.jatrix.solvers;

import com.jatrix.core.Matrix;
import com.jatrix.exceptions.MatrixSizeException;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.exceptions.SolverNotSupportedException;

/**
 * Class for solution of a quadratic system of linear algebraic equations with nonzero determinant of the basic matrix
 */

public class CramerSolver {
    private Matrix a;
    private double[] b;
    private double[] x;

    public Matrix getMatrix() {
        return a;
    }

    public double[] getRoots() {
        return x;
    }

    public double[] getConstants() {
        return b;
    }

    /**
     * A basic constructor, used for solving the matrix by the Cramer method
     * @param a - given matrix
     * @param b - coefficients in the right part of the equation
     */

    public CramerSolver(Matrix a, double[] b) {
        if (a.getRowDimension() != b.length)
            throw new MatrixSizeException("Matrix and constant's vector dimensions must be equaled");
        this.a = a.clone();
        this.b = b;
        solve();
    }

    private void solve() {
        LUDecomposition lu = new LUDecomposition(a);
        double det = lu.det();
        if (Math.abs(det) < 1E-15)
            throw new SolverNotSupportedException("The Cramer's method is not applicable to the matrix." +
                    "\nThe determinant is equaled or near to 0");

        x = new double[a.getColumnDimension()];
        for (int i = 0; i < a.getColumnDimension(); i++) {
            Matrix tempMatrix = a.clone();
            for (int j = 0; j < a.getRowDimension(); j++) {
                tempMatrix.set(j, i, b[j]);
            }
            lu = new LUDecomposition(tempMatrix);
            x[i] = lu.det() / det;
        }
    }

    @Override
    public String toString() {
        StringBuilder solutions = new StringBuilder("Roots: \n");
        for (int i = 0; i < a.getColumnDimension(); i++) {
            solutions.append(String.format("X{%d} = %f%n", i+1, x[i]));
        }
        return solutions.toString();
    }
}
