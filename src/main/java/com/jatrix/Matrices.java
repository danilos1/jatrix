package main.java.com.jatrix;

import java.util.Random;

/**
 * Matrices class is intended for performing basic matrix operations such as
 * adding, multiplication, searching, etc.
 */
public class Matrices {

    private Matrices() { }


    private static boolean isNotEqualsDimensions(Matrix m1, Matrix m2) {
        return m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns();
    }


    public static Matrix add(Matrix m1, Matrix m2) {
        if (isNotEqualsDimensions(m1, m2))
            throw new MatrixSizeException("Dimensions of matrices must be equaled");

        int rows = m1.getRows();
        int columns = m2.getColumns();
        Matrix newMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix.set(i, j, m1.get(i, j) + m2.get(i, j));
            }
        }

        return newMatrix;
    }


    public static Matrix sub(Matrix m1, Matrix m2) {
        if (isNotEqualsDimensions(m1, m2))
            throw new MatrixSizeException("Dimensions of matrices must be equaled");

        int rows = m1.getRows();
        int columns = m2.getColumns();
        Matrix newMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix.set(i, j, m1.get(i, j) - m2.get(i, j));
            }
        }

        return newMatrix;
    }


    public static void fillRandom(Matrix m) {
        Random random = new Random();
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                m.set(i, j, random.nextInt(20) - 10);
            }
        }
    }


    public static Matrix multiply(Matrix m1, Matrix m2) {
        if (m1.getColumns() != m2.getRows())
            throw new MatrixSizeException("Invalid multiplication operation. Number of columns of the first matrix " +
                    "must be equaled to number of rows of the second one. Expected: " + m1.getColumns() + ", but founded: "
                    + m2.getRows());

        int rows = m1.getRows();
        int cols = m2.getColumns();
        int sum = m1.getColumns();
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


    public static Matrix mul(Matrix m1, Matrix m2) {
        if (m1.getColumns() != m2.getRows())
            throw new MatrixSizeException("Invalid multiplication operation. Number of columns of the first matrix " +
                    "must be equaled to number of rows of the second one. Expected: " + m1.getColumns() + ", but founded: "
                    + m2.getRows());

        if (m1.isSquare() && m1.isPair() && m2.isSquare() && m2.isPair() && m1.getRows() > 32) {
            return StrassenProduct.mul(m1, m2);
        }

        int rows = m1.getRows();
        int cols = m2.getColumns();
        int sum = m1.getColumns();
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


    public static Matrix mul(double c, Matrix matrix) {
        int rows = matrix.getRows();
        int cols = matrix.getColumns();
        Matrix newMatrix = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix.set(i, j,c * matrix.get(i, j));
            }
        }

        return newMatrix;
    }


    public static Matrix transpose(Matrix matrix) {
        int rows = matrix.getRows();
        int cols = matrix.getColumns();
        Matrix transposedMatrix = new Matrix(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix.set(i, j, matrix.get(j, i));
            }
        }

        return transposedMatrix;
    }


    public static Matrix inverse(Matrix matrix) {
        return null;
    }
}