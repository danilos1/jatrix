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

        Matrix resultMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix.set(i, j, m1.get(i, j) + m2.get(i, j));
            }
        }
        return resultMatrix;
    }

    public static Matrix sub(Matrix m1, Matrix m2) {
        if (!isEqualsDimensions(m1, m2))
            throw new MatrixSizeException("Dimensions of matrices must be equaled");

        int rows = m1.getRows();
        int columns = m2.getColumns();

        Matrix resultMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix.set(i, j, m1.get(i, j) - m2.get(i, j));
            }
        }
        return resultMatrix;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        return null;
    }

    public static Matrix multiply(double m1, Matrix m2) {
        return null;
    }

    public static Matrix division(Matrix m1, Matrix m2) {
        return null;
    }

    public static void transpose(Matrix matrix) {
        int rows = matrix.getRows();
        int cols = matrix.getColumns();

        Matrix transposedMatrix = new Matrix(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix.set(i, j, matrix.get(j, i));
            }
        }
        matrix.setMatrix(transposedMatrix.getMatrix());
    }

}
