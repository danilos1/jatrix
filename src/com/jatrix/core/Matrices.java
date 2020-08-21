package com.jatrix.core;

import com.jatrix.conversion.MatrixConversion;
import com.jatrix.exceptions.MatrixSingularException;
import com.jatrix.exceptions.MatrixSizeException;

import java.util.Random;

/**
 * Matrices class is intended for performing basic matrix operations such as
 * adding, subtraction, multiplication, searching,  etc.
 */

public class Matrices {

    private Matrices() {
    }

    private static boolean isNotEqualsDimensions(Matrix m1, Matrix m2) {
        return m1.getRowDimension() != m2.getRowDimension() || m1.getColumnDimension() != m2.getColumnDimension();
    }


    /**
     * This method is used to make the sum of two matrices.
     * @param m1 - first matrix to add method
     * @param m2 - second matrix to add method
     * @return newMatrix - sum of m1 and m2
     */

    public static Matrix add(Matrix m1, Matrix m2) {
        if (isNotEqualsDimensions(m1, m2))
            throw new MatrixSizeException("Dimensions of matrices must be equaled");

        int rows = m1.getRowDimension();
        int columns = m2.getColumnDimension();
        Matrix newMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix.set(i, j, m1.get(i, j) + m2.get(i, j));
            }
        }

        return newMatrix;
    }

    /**
     * This method is used to make a difference of two matrices.
     * @param m1 - first matrix to sub method
     * @param m2 - second matrix to sub method
     * @return newMatrix - a difference of m1 and m2
     */

    public static Matrix sub(Matrix m1, Matrix m2) {
        if (isNotEqualsDimensions(m1, m2))
            throw new MatrixSizeException("Dimensions of matrices must be equaled");

        int rows = m1.getRowDimension();
        int columns = m2.getColumnDimension();
        Matrix newMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix.set(i, j, m1.get(i, j) - m2.get(i, j));
            }
        }

        return newMatrix;
    }

    /**
     * Fills the matrix with random numbers
     * @param m - matrix to fillRandom method
     */

    public static void fillRandom(Matrix m) {
        Random random = new Random();
        for (int i = 0; i < m.getRowDimension(); i++) {
            for (int j = 0; j < m.getColumnDimension(); j++) {
                m.set(i, j, random.nextDouble());
            }
        }
    }

    /**
     * This method implements the multiplication of two matrices.
     *
     * For example, let's consider we have matrices A and B.
     * If A = [Aij] is an m x n and B = [Bij] is an n x p matrix,
     * the product AB is an m x p matrix.
     * AB = [Cij], where Cij = Ai1 * B1j + Ai2 * B2j + ... + Ain * Bnj
     *
     * @param m1 - first matrix to mul method
     * @param m2 - second matrix to mul method
     * @return newMatrix - result of m1 and m2 multiplication
     */

    public static Matrix mul(Matrix m1, Matrix m2) {
        if (m1.getColumnDimension() != m2.getRowDimension())
            throw new MatrixSizeException("Invalid multiplication operation. Number of columns of the first matrix " +
                    "must be equaled to number of rows of the second one. Expected: " + m1.getColumnDimension() + ", but founded: "
                    + m2.getRowDimension());


        if (m1.isSquare() && m1.isPair() && m2.isSquare() && m2.isPair() && m1.getRowDimension() > 32) {
            return StrassenProduct.mul(m1, m2);
        }

        int rows = m1.getRowDimension();
        int cols = m2.getColumnDimension();
        int sum = m1.getColumnDimension();
        Matrix newMatrix = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double s = 0;
                for (int k = 0; k < sum; k++) {
                    s += m1.get(i, k) * m2.get(k, j);
                }
                newMatrix.set(i, j, s);
            }
        }

        return newMatrix;
    }

    /**
     * Simple multiplication of the matrix by a constant.
     * @param c - arbitrary number, constant
     * @param matrix - matrix to mul method
     * @return newMatrix - result of multiplication matrix by c
     */

    public static Matrix mul(double c, Matrix matrix) {
        int rows = matrix.getRowDimension();
        int cols = matrix.getColumnDimension();
        Matrix newMatrix = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix.set(i, j, c * matrix.get(i, j));
            }
        }

        return newMatrix;
    }

    /**
     * This method perform matrix transposition
     * Is obtained by changing rows to columns and columns to rows.
     * @param matrix - matrix to transpose method
     * @return transposedMatrix - transposed matrix
     */

    public static Matrix transpose(Matrix matrix) {
        int rows = matrix.getRowDimension();
        int cols = matrix.getColumnDimension();
        Matrix transposedMatrix = new Matrix(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix.set(i, j, matrix.get(j, i));
            }
        }

        return transposedMatrix;
    }


    /**
     * A method for finding an inversion of the matrix, using Gauss Elimination
     * @param matrix - the matrix for which you want to get the inversion
     * @return an inverse matrix
     */

    public static Matrix inverse(Matrix matrix) {
        if (!matrix.isSquare())
            throw new MatrixSizeException("Matrix must be square. Founded: " +
                    matrix.getRowDimension() + " x " + matrix.getColumnDimension());

        int size = matrix.getRowDimension();
        Matrix A = matrix.clone();
        Matrix B = new Matrix(size).identity();


        // Forward substitution
        for (int i = 0; i < size - 1; i++) {
            if (A.get(i, i) == 0) {
                for (int j = i+1; j < size; j++) {
                    if (A.get(j, i) == 0) {
                        if (j == size-1) {
                            throw new MatrixSingularException("Matrix is singular");
                        }
                    }
                    else {
                        MatrixConversion.swapRows(A, i, j);
                        MatrixConversion.swapRows(B, i, j);
                        break;
                    }
                }
            }

            for (int k = i+1; k < size; k++) {
                double div = A.get(k,i)/A.get(i, i);
                for (int j = 0; j < size; j++) {
                    A.set(k, j, A.get(k,j) - A.get(i,j)*div);
                    B.set(k, j, B.get(k,j) - B.get(i,j)*div);
                }
            }
        }

        // Back substitution
        for (int i = size - 1; i > 0; i--) {
            if (A.get(i, i) == 0) {
                for (int j = i+1; j < size; j++) {
                    if (A.get(j, i) == 0) {
                        if (j == size-1) {
                            throw new MatrixSingularException("Matrix is singular");
                        }
                    }
                    else {
                        MatrixConversion.swapRows(A, i, j);
                        MatrixConversion.swapRows(B, i, j);
                        break;
                    }
                }
            }

            for (int k = i-1; k >= 0; k--) {
                double div = A.get(k,i)/A.get(i, i);
                for (int j = size - 1; j >= 0; j--) {
                    A.set(k, j, A.get(k,j) - A.get(i,j)*div);
                    B.set(k, j, B.get(k,j) - B.get(i,j)*div);
                }
            }
        }

        // Correction
        for (int i = 0; i < size; i++) {
            double d = A.get(i, i);
            if (d == 0)
                throw new MatrixSingularException("Matrix is singular");
            if (d == 1) continue;
            for (int j = 0; j < size; j++) {
                B.set(i, j, B.get(i, j)/d);
            }
        }

        return B;
    }
}