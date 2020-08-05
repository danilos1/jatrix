package com.matrix_java;

/**
 * Matrix class is used as a representation of a matrix
 * @param <T> - some type of values, containing in a matrix
 */
public class Matrix<T> implements Cloneable {
    T[][] matrix;
    private final int row, col;
    private Solver solver;  
    
    public void clear() {
        matrix = null;
    }
    
    public int getRows() {
        return row;
    }

    public int getColumns() {
        return col;
    }
       
    public T get(int row, int col) {
        return matrix[row][col];
    }
    
    public void set(int row, int col, T item) {
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




    /**
     * A class for getting a solver of concrete matrix.
     */
    public static class Solver { }
    
    /**
     * A method for checking if a matrix is square (quantity of rows and columns must be equals)
     * @return returns a result if a matrix is pair (Quantity of rows and 
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
        matrix =  (T[][]) (new Object[row][col]);
        this.row = row;
        this.col = col;
    }
    
    /**
     * A basic constructor, used for creating a matrix row x col size with filled values of val parameter
     * @param row - quantity of rows
     * @param col - quantity of columns
     * @param val - some value, which is filler of matrix
     */
    public Matrix(int row, int col, T val) {
        matrix =  (T[][]) (new Object[row][col]);
        this.row = row;
        this.col = col;
        fill(val);
    }
    
    /**
     * A basic constructor, receiving an array of some type T .
     * @param matrix - a filled matrix of type T .
     */
    public Matrix(T[][] matrix) {
        checkSize(matrix);
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }

    private void fill(T val) {
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
    
    private void checkSize(T[][] matrix) {
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

    /**
     * A method that transposes some matrix.
     * @return Returns a transpose matrix of concrete matrix.
     */
    public Matrix<T> getTranspose() {
        Matrix<T> matrixT = new Matrix<>(col, row);
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

    public T[][] toArray() {
        return matrix;
    }

    @Override
    public Matrix<T> clone() {
        Matrix<T> matrix = new Matrix<>(row, col);
        for (int i = 0; i < row; i++) {
            System.arraycopy(this.matrix[i], 0, matrix.matrix[i], 0, col);
        }
        return matrix;
    }
}
