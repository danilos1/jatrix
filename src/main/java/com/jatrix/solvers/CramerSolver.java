package com.jatrix.solvers;

import com.jatrix.core.Matrix;
import com.jatrix.exceptions.MatrixSizeException;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.exceptions.SolverNotSupportedException;

/**
 * Class for solution of a quadratic system of linear algebraic equations with nonzero determinant of a {@link Matrix}
 * object.
 */
public class CramerSolver {
    private Matrix a;
    private double[] b;
    private double[] x;


    /**
     * Gets a {@link Matrix} object, representing a set of unknown variables.
     * @return Matrix object
     */
    public Matrix getMatrix() {
        return a;
    }


    /**
     * Gets roots of solving a system of linear equations.
     * @return roots of solving a system of linear equations into an array.
     */
    public double[] getRoots() {
        return x;
    }


    public double[] getConstants() {
        return b;
    }


    /**
     * Constructs a CramerSolver object received a matrix and array of coefficients.
     * @param a Matrix object, representing a matrix of unknown variables.
     * @param b a coefficients array in the right part of the system of equations.
     */
    public CramerSolver(Matrix a, double[] b) {
        if (!a.isSquare()) {
            throw new SolverNotSupportedException("Matrix of must be squared");
        }
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
