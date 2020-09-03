package com.jatrix.solvers;

import com.jatrix.conversion.MatrixConversion;
import com.jatrix.core.Matrix;
import com.jatrix.decompositions.LUDecomposition;
import com.jatrix.exceptions.MatrixSingularException;
import com.jatrix.exceptions.MatrixSizeException;
import com.jatrix.exceptions.SolverNotSupportedException;

/**
 * Class for solution of a quadratic system of linear algebraic equations with nonzero determinant of a {@link Matrix}
 * object.
 */

public class GaussSolver {
    private Matrix matrix;
    private double[] b;
    private double[] x;


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
     * Gets a {@link Matrix} object, representing a set of unknown variables.
     * @return Matrix object
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Constructs a GaussSolver object received a matrix and array of coefficients.
     * @param matrix Matrix object, representing a matrix of unknown variables.
     * @param b a coefficients array in the right part of the system of equations.
     */
    public GaussSolver(Matrix matrix, double[] b) {
        if (!matrix.isSquare()) {
            throw new SolverNotSupportedException("Matrix of must be squared");
        }
        if (matrix.getRowDimension() != b.length)
            throw new MatrixSizeException("Matrix and constant's vector dimensions must be equaled");
        this.matrix = matrix.clone();
        this.b = b;
        this.x = b;
        solve();
    }


    private void solve() {
        int size = matrix.getRowDimension();
        Matrix A = matrix.clone();
        for (int i = 0; i < size - 1; i++) {
            if (A.get(i, i) == 0) {
                for (int j = i+1; j < size; j++) {
                    if (A.get(j, i) == 0) {
                        if (j == size-1) {
                            throw new MatrixSingularException("Matrix is singular. So, the system of linear equations " +
                                    "does not have roots.");
                        }
                    }
                    else {
                        MatrixConversion.swapRows(A, i, j);
                        double temp = x[i];
                        x[i] = x[j];
                        x[j] = temp;
                        break;
                    }
                }
            }

            for (int k = i+1; k < size; k++) {
                double div = A.get(k,i)/A.get(i, i);
                for (int j = 0; j < size; j++) {
                    A.set(k, j, A.get(k,j) - A.get(i,j)*div);
                }
                x[k] -= x[i]*div;
            }
        }


        for (int i = size - 1; i >= 0; i--) {
            double mid = A.get(i,i);
            if (mid == 0) {
                System.out.println("The system of linear equations doesn't have roots!");
                break;
            }
            for (int j = i + 1; j < size; j++) {
                x[i] -= A.get(i, j)*x[j];
            }
            x[i] /= A.get(i,i);
        }
    }


    @Override
    public String toString() {
        StringBuilder solutions = new StringBuilder("Roots: \n");
        for (int i = 0; i < matrix.getColumnDimension(); i++) {
            solutions.append(String.format("X{%d} = %f%n", i+1, x[i]));
        }
        return solutions.toString();
    }
}
