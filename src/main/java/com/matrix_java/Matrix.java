package com.matrix_java;

import java.util.Arrays;

/**
 *
 * @author admin
 * @param <T>
 * Matrix class is used as a representation of a matrix
 */
public class Matrix<T> implements Cloneable {
    private T[][] matrix;
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
    
    public Solver getSolver() {
        if (solver == null) solver = new Solver();
        return solver;
    }    

    public class Solver { }
    
    /**
     * 
     * @return returns a result if a matrix is pair (Quantity of rows and 
     * columns must be same)
     */
    public boolean isSquare() {
        return row == col;
    }
    
    /**
     * @param row - quantity of rows
     * @param col - quantity of columns
     */
    public Matrix(int row, int col) {
        matrix =  (T[][]) (new Object[row][col]);
        this.row = row;
        this.col = col;
    }
    
    /**
     * 
     * @param matrix 
     */
    public Matrix(T[][] matrix) {
        checkSize(matrix);
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }
    
    /**
     * 
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
    
    public Matrix getTranspose() {
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

    /**
     * TODO
     */
    /*@Override
    public Matrix clone() {
        Matrix<T> newMatrix = new Matrix(row, col);
        try {
            newMatrix = (Matrix) super.clone(); 
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return newMatrix;
    }*/
}
