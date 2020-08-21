package com.jatrix.core;

import java.util.Iterator;

/**
 * MatrixIterator represents an iterator of the Matrix object.
 * @see Matrix
 * @see Iterator
 */
public class MatrixIterator implements Iterator<Double> {
    private double[][] matrix;
    private int i, j;
    private int row, col;

    /**
     * Constructs a MatrixIterator object, received a two-dimensional array underlying matrix.
     * @param matrix two-dimensional array underlying matrix.
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
