package main.java.com.jatrix;

/**
 * Matrices class is intended for performing basic matrix operations such as
 * adding, multiplication, searching, etc.
 */
public class Matrices {

    private Matrices() { }

    private static boolean isEqualsDimensions(Matrix m1, Matrix m2) {
        return m1.getRows() == m2.getRows() && m1.getColumns() == m2.getColumns();
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if (!isEqualsDimensions(m1, m2))
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
        if (!isEqualsDimensions(m1, m2))
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

    private static boolean ableToMultiplication(Matrix m1, Matrix m2) {
        return m1.getColumns() == m2.getRows();
    }

    public static Matrix mul(Matrix m1, Matrix m2) {
        if (!ableToMultiplication(m1, m2))
            throw new MatrixSizeException("Invalid multiplication operation. Number of columns of the first matrix " +
                    "must be equaled to number of rows of the second one. Expected: "+m1.getColumns()+", but founded: "
            + m2.getRows());

        // Code for multiplication
        
        return null;
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
}
