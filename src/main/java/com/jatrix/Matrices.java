package com.jatrix;

/**
 * Matrices class is intended for performing basic matrix operations such as
 * adding, multiplication, searching, etc.
 */
public class Matrices {
    
    private Matrices() {}
    

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
