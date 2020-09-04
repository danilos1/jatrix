package com.jatrix.core;

import com.jatrix.exceptions.MatrixSizeException;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.StreamSupport;

/**
 * Matrix class is used as a representation of a simple matrix
 */
public class Matrix implements Cloneable, Iterable<Double> {
    private double[][] matrix;


    private final int row, col;


    /**
     * Assigns a new specified matrix, defined as a two-dimensional array to a current matrix.
     * @param matrix set new matrix
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }


    /**
     * Clears all whole matrix, assigns zeros to all matrix elements.
     */
    public void clear() {
        matrix = new double[row][col];
    }


    /**
     * Receives a number of matrix rows.
     * @return row dimension
     */
    public int getRowDimension() {
        return row;
    }

    /**
     * Receives a number of matrix columns.
     * @return col - column dimension
     */
    public int getColumnDimension() {
        return col;
    }

    /**
     * Receives a double value of a matrix by <code>rowIdx</code> and <code>colIdx</code> index position.
     * @param rowIdx index by rows.
     * @param colIdx index by columns.
     * @return element of a matrix for the specified parameters.
     */
    public double get(int rowIdx, int colIdx) {
        return matrix[rowIdx][colIdx];
    }

    /**
     * Assigns values to specific indices.
     * @param rowIdx index by rows
     * @param colIdx index by columns
     * @param item assigned value
     */
    public void set(int rowIdx, int colIdx, double item) {
        matrix[rowIdx][colIdx] = item;
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
     * Return boolean result, checking if a matrix is square (number of rows and columns must be equals).
     * @return boolean true if a matrix is pair (quantity of rows and columns must be same) and false elsewhere.
     */
    public boolean isSquare() {
        return row == col;
    }


    /**
     * Constructs a Matrix object, received a number of rows and columns.
     * @param row - number of matrix rows.
     * @param col - number of matrix columns.
     * @throws MatrixSizeException if row or column of a matrix is equaled or less than zero.
     */
    public Matrix(int row, int col) {
        matrix = new double[row][col];
        this.row = row;
        this.col = col;
    }


    /**
     * Constructs a Matrix object, received row and columns dimensions and value to fill the matrix.
     * @param row number of matrix rows.
     * @param col number of matrix columns.
     * @param val some value, which is filler of matrix.
     * @throws MatrixSizeException if row or column of a matrix is equaled or less than zero.
     */
    public Matrix(int row, int col, double val) {
        this(row, col);
        fill(val);
    }


    /**
     * A basic constructor, receiving an array of some type T .
     * @param matrix filled matrix of type T .
     * @throws MatrixSizeException if number of columns are not equaled to each other.
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
     * Constructs a Matrix object, received a size, which is a quantity of rows and columns simultaneously.
     * @param size quantity of rows and columns simultaneously.
     * @throws MatrixSizeException if row or column of a matrix is equaled or less than zero.
     */
    public Matrix(int size) {
        this(size, size);
    }

    /**
     * Fills matrix with random double values
     * @return current matrix of randomly filled double values
     */
    public Matrix random() {
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.set(i,j, random.nextDouble());
            }
        }
        return this;
    }


    /**
     * Fills matrix with random int values within a <code>range</code>
     * (from -<code>range</code> to +<code>range</code> bounds, inclusively)
     * @return current matrix of randomly filled int values within a <code>range</code> bounds
     */
    public Matrix random(int range) {
        return this.random(-range, range);
    }


    /**
     * Fills matrix with random int values within a <code>range</code> (from <code>start</code> to <code>end</code>
     * bounds, inclusively)
     * @return current matrix of randomly filled int values within a range:
     * from <code>start</code> to <code>end</code> bounds
     */
    public Matrix random(int start, int end) {
        Random random = new Random();
        int l = end - start + 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.set(i,j, random.nextInt(l) + start);
            }
        }
        return this;
    }


    /**
     * A method for converting the matrix to identity matrix.
     * @return current matrix, converted to identity matrix
     * (a matrix with ones on the main diagonal and zeros elsewhere).
     */
    public Matrix identity() {
        if (row != col) {
            throw new MatrixSizeException("Matrix must be squared to identity");
        }
        matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i][i] = 1;
        }
        return this;
    }


    /**
     * Constructs a Matrix object, which has size by size dimensions and fills a matrix with some value <code>val</code>.
     * @param size matrix order or a number of rows and cols simultaneously.
     * @param val value to fill the matrix.
     * @throws MatrixSizeException if row or column of a matrix is equaled or less than zero.
     */
    public Matrix(int size, double val) {
        this(size, size, val);
    }


    private void checkSize(double[][] matrix) {
        int cur = matrix[0].length;
        for (int i = 0; i < matrix.length - 1; i++) {
            int next = matrix[i + 1].length;
            if (cur != next)
                throw new MatrixSizeException("Columns dimensions "
                        + "are not matched! Expected row of " + cur + " size, but founded: "
                        + next);
            cur = next;
        }
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(row, col);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }


    @Override
    public boolean equals(Object matrix) {
        if (matrix == null) throw new NullPointerException("Matrix cannot be equaled to null");
        if (!(matrix instanceof Matrix))
            throw new ClassCastException("Cannot cast " + matrix.getClass().getName() + " to Matrix");

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
     * @return DoubleStream object of the matrix
     */
    public DoubleStream stream() {
        return StreamSupport.doubleStream(this.spliterator(), false);
    }


    /**
     * A method for supporting parallel streams using Stream API.
     * TODO
     * @return parallel {@link DoubleStream} object.
     */
    public DoubleStream parallelStream() {
        return null;
    }


    /**
     * Transposes some matrix. It means the following operation:<br>
     * Let's suppose we have a matrix, which we need to transpose:<br>
     *    |  1  | 2 |                                                 |  1  | -5 | 2 |
     * A =| -5  | 7 | , so the transposed matrix looks like this At = |  2  |  7 | 1 |
     *    |  2  | 1 |
     * @return transposed matrix of the specified matrix.
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
     * Outputs a matrix in a pretty form, which means an output of the matrix with equal indents.
     * @return output of matrix in a pretty form into String object.
     */
    public String prettyOut() {
        return this.prettyOut(3);
    }


    /**
     * Prints out a matrix in a pretty form, which means an output of the matrix with equal indents.
     * @param accuracy number of decimal places.
     * @return output of matrix in a pretty form into String object.
     * @see #prettyOut()
     */
    public String prettyOut(int accuracy) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The size of the matrix: %d x %d", row, col)).append("\n");
        sb.append("An accuracy: ").append(accuracy).append("\n\n");

        double[] columnLengths = new double[col];
        for (int i = 0; i < col; i++) {
            int maxLength = String.valueOf((int)matrix[0][i]).length();
            for (int j = 1; j < row; j++) {
                int cur = String.valueOf((int) matrix[j][i]).length();
                if (Math.abs(cur) > Math.abs(maxLength)) maxLength = cur;
            }
            columnLengths[i] = maxLength + 1;
        }
        for (int i = 0; i < row; i++) {
            sb.append("| ");
            for (int j = 0; j < col; j++) {
                String format = "%-"+(columnLengths[j] + accuracy + 1)+accuracy+"f | ";
                sb.append(String.format(format, matrix[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    /**
     * Returns the matrix into a two-dimensional array.
     * @return two-dimensional array underlying in the matrix.
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


    /**
     * Assigns new values of <code>newCol</code> array for the matrix row at <code>i</code> index position.
     * @param i index of matrix a row.
     * @param newCol array of numeric values.
     */
    public void setRow(int i, double[] newCol) {
        matrix[i] = newCol;
    }


    /**
     * Receives a set of values of the the matrix column at <code>i</code> index position.
     * @param i index of a matrix column
     * @return c array of numeric values
     */
    public double[] getColumn(int i) {
        double[] c = new double[row];
        for (int j = 0; j < row; j++) {
            c[j] = matrix[j][i];
        }
        return c;
    }


    /**
     * Checks if a matrix is pair, returning true if row and column dimensions are pair, and false elsewhere.
     * @return boolean true if row and column dimensions are pair, and false elsewhere.
     */
    public boolean isPair() {
        return (row & 0b1) == 0 && (col & 0b1) == 0;
    }


    /**
     * Checks if the matrix contains the specified element.
     * @param item element which need to be searched.
     * @return boolean true if element is existed in the matrix and false if it's not in the matrix.
     */
    public boolean contains(double item) {
        for (int i = 0; i < row; i++) {
            int l = 0, h = col - 1;
            while (l <= h) {
                int mid = (l + h) >> 1;
                if (item > matrix[i][mid]) {
                    l = mid + 1;
                } else if (item < matrix[i][mid]) {
                    h = mid - 1;
                } else return true;
            }
        }
        return false;
    }


    /**
     * Receives values of the specified matrix row by row index.
     * @param rowIdx index of matrix row.
     * @return array of numeric values.
     */
    public double[] getRow(int rowIdx) {
        return matrix[rowIdx];
    }


    /**
     * Assigns new values for the matrix column by column index.
     * @param colIdx index of a matrix column
     * @param newCol array of numeric values
     */
    public void setColumn(int colIdx, double[] newCol) {
        for (int i = 0; i < row; i++) {
            matrix[i][colIdx] = newCol[i];
        }
    }
}