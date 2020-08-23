package com.jatrix.core;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.DoubleConsumer;

/**
 * MatrixSplitIterator represents a split iterator of the Matrix object.
 * @see Matrix
 * @see Spliterator
 */
public class MatrixSplitIterator implements Spliterator.OfDouble {
    private final double[][] matrix;
    private int start, end;
    private int row, col;

    /**
     * Constructs a MatrixSplitIterator object, received a two-dimensional array underlying matrix.
     * @param matrix two-dimensional array underlying matrix.
     */
    public MatrixSplitIterator(double[][] matrix) {
        this(matrix, 0, 0);
    }


    /**
     * Constructs a MatrixIterator object, received a two-dimensional array underlying matrix.
     * @param matrix two-dimensional array underlying matrix.
     * @param start start index for splitting a matrix.
     * @param end end index for splitting a matrix.
     * @see #trySplit()
     */
    public MatrixSplitIterator(double[][] matrix, int start, int end) {
        this.matrix = matrix;
        this.start = start;
        this.end = end;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }


    @Override
    public boolean tryAdvance(DoubleConsumer doubleConsumer) {
        if (!(start == row-1 && end == col)) {
            if (end == col && start != row) {
                start++;
                end = 0;
            }
            doubleConsumer.accept(matrix[start][end++]);
            return true;
        }
        return false;
    }


    @Override
    public OfDouble trySplit() {
        int size = matrix.length;
        if (size == 2) {
            return null;
        }

        int newStart = 0, newEnd = end;
        if ((size & 0b1) == 0) {
            newStart = start + size >> 1;
        }
        else {
            newStart = start + (size >> 1 + 1);
        }
        return new MatrixSplitIterator(matrix, newStart, newEnd);
    }


    @Override
    public long estimateSize() {
        return matrix.length * matrix[0].length;
    }


    @Override
    public int characteristics() {
        return IMMUTABLE | NONNULL;
    }
}
