package main.java.com.jatrix;


import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Matrix class is used as a representation of a matrix
 */
public class Matrix implements Cloneable, Iterable<Double> {
    private double[][] matrix;
    private final int row, col;
    private Solver solver;


    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }


    public double[][] getMatrix() {
        return matrix;
    }


    public void clear() {
        matrix = new double[row][col];
    }


    public int getRows() {
        return row;
    }


    public int getColumns() {
        return col;
    }


    public double get(int row, int col) {
        return matrix[row][col];
    }


    public void set(int row, int col, double item) {
        matrix[row][col] = item;
    }


    /**
     * A method for getting a solver of a matrix.
     * @return Returns a solver of concrete matrix.
     */
    public Solver getSolver() {
        if (solver == null) solver = new Solver();
        return solver;
    }


    @Override
    public MatrixIterator iterator() {
        return new MatrixIterator(matrix);
    }


    @Override
    public MatrixSplitIterator spliterator() {
        return new MatrixSplitIterator(matrix);
    }


    /**
     * A class for getting a solver of concrete matrix.
     */
    public static class Solver {
        private Solver() {}

        public double getDeterminant() {
            return 0;
        }
    }


    /**
     * A method for checking if a matrix is square (number of rows and columns must be equals)
     * @return a result if a matrix is pair (Quantity of rows and
     * columns must be same)
     */
    public boolean isSquare() {
        return row == col;
    }


    /**
     * A basic constructor, used for creating a matrix of row x col size
     * @param row - quantity of rows
     * @param col - quantity of columns
     */
    public Matrix(int row, int col) {
        matrix = new double[row][col];
        this.row = row;
        this.col = col;
    }


    /**
     * A basic constructor, used for creating a matrix row x col size with filled values of val parameter
     * @param row - quantity of rows
     * @param col - quantity of columns
     * @param val - some value, which is filler of matrix
     */
    public Matrix(int row, int col, double val) {
        matrix =  new double[row][col];
        this.row = row;
        this.col = col;
        fill(val);
    }


    /**
     * A basic constructor, receiving an array of some type T .
     * @param matrix - a filled matrix of type T .
     */
    public Matrix(double[][] matrix) {
        checkSize(matrix);
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }


    private void fill(double val) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = val;
            }
        }
    }

    /**
     * A basic constructor, receiving a size, which is a quantity of rows and columns simultaneously.
     * @param size - a quantity of rows and columns simultaneously
     */
    public Matrix(int size) {
        this(size, size);
    }

    /**
     * TODO
     * @param size
     * @param val
     */
    public Matrix(int size, double val) {
        this(size, size, val);
    }

    private void checkSize(double[][] matrix) {
        int cur = matrix[0].length;
        for (int i = 0; i < matrix.length - 1; i++) {
            int next = matrix[i+1].length;
            if (cur != next)
                throw new MatrixSizeException("Columns dimensions "
                        + "are not matched! Expected row of "+cur+" size, but founded: "
                        +next);
            cur = next;
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(row, col, solver);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public boolean equals(Object matrix) {
        if (matrix == null) throw new NullPointerException("Matrix cannot be equaled to null");
        if (!(matrix instanceof Matrix))
            throw new ClassCastException("Cannot cast "+matrix.getClass().getName()+" to Matrix");

        Matrix matrix1 = (Matrix) matrix;

        if (row != matrix1.row || col != matrix1.col) return false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (this.matrix[i][j] != matrix1.matrix[i][j]) return false;
            }
        }
        return true;
    }

    /**
     * A method for supporting a Stream API with matrices
     * @return a DoubleStream of the matrix
     */
    public DoubleStream stream() {
        return StreamSupport.doubleStream(this.spliterator(), false);
    }

    /**
     * A method that transposes some matrix.
     * @return a transpose matrix of concrete matrix.
     */
    public Matrix getTranspose() {
        Matrix matrixT = new Matrix(col, row);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrixT.matrix[i][j] = matrix[j][i];
            }
        }
        return matrixT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * A method, which outs a matrix in a pretty form
     * TODO
     * @return a matrix in a pretty form
     */
    public String prettyOut() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The size of matrix: %d x %d", row, col));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // code
            }
        }
        return sb.toString();
    }

    /**
     * A method for converting the matrix into two-dimensional array
     * @return a two-dimensional array underlying in the matrix
     */
    public double[][] toArray() {
        return matrix;
    }


    @Override
    public Matrix clone() {
        Matrix matrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            System.arraycopy(this.matrix[i], 0, matrix.matrix[i], 0, col);
        }
        return matrix;
    }


    public double[] getRow(int i) {
        return matrix[i];
    }


    public boolean isPair() {
        return (row & 0b1) == 0 && (col & 0b1) == 0;
    }


    /**
     * TODO
     * A method for checking if the matrix contains the specified element (item).
     * @param item
     * @return true if element is existed in the matrix and false if it's not in the matrix.
     */
    public boolean contains(double item) {
        return false;
    }
}