package com.jatrix.core;

import java.util.Iterator;

/**
 * Class for iterating over a matrix
 */

public class MatrixIterator implements Iterator<Double> {
    private double[][] matrix;
    private int i, j;
    private int row, col;

    /**
     * A basic constructor, used for iterating over a matrix
     * @param matrix - a basic matrix
     */

    public MatrixIterator(double[][] matrix) {
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
    }

    @Override
    public boolean hasNext() {
        return !(i == row-1 && j == col);
    }

    @Override
    public Double next() {
        if (j == col && i != row) {
            i++;
            j = 0;
        }
        return matrix[i][j++];
    }
}
