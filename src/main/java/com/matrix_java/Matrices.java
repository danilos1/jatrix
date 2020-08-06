package com.matrix_java;

import java.util.Comparator;

/**
 * <code>Matrices</code> class is intended for performing basic matrix operations such as
 * adding, multiplication, searching, etc.
 */
public class Matrices {
    
    private Matrices() {}
    
    public static <T extends Number> Matrix<T> add(Matrix<T> m1, Matrix<T> m2) { return null; }

    public static <T extends Number> Matrix<T> add(Matrix<T> dest, Matrix<T> m1, Matrix<T> m2) { return null; }
    
    public static <T extends Number> Matrix<T> multiply(Matrix<T> m1, Matrix<T> m2) { return null; }
    
    public static <T extends Number> Matrix<T> multiply(Matrix<T> dest, Matrix<T> m1, Matrix<T> m2) { return null; }
    
    public static <T> void sort() {}
    
    public static <T extends Number> void sort(Matrix<T> matrix, Comparator<? extends T> comparator) { }

    public static <T extends Number> void transpose(Matrix<T> matrix) {
        int rows = matrix.getRows();
        int cols = matrix.getColumns();

        Matrix<T> transposedMatrix = new Matrix<>(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix.set(i, j, matrix.get(j, i));
            }
        }
        matrix.setMatrix(transposedMatrix.getMatrix());
    }
   
}
