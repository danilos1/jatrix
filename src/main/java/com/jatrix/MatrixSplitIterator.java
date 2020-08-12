package main.java.com.jatrix;

import java.util.Spliterator;
import java.util.function.DoubleConsumer;

public class MatrixSplitIterator implements Spliterator.OfDouble {
    private final double[][] matrix;
    private int start, end;
    private int row, col;

    public MatrixSplitIterator(double[][] matrix) {
        this(matrix, 0, 0);
    }

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
