package main.java.com.jatrix;

import java.util.Spliterator;
import java.util.function.Consumer;

public class MatrixSplitIterator implements Spliterator<Double> {
    private double[][] matrix;

    public MatrixSplitIterator(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Double> consumer) {

        return false;
    }

    @Override
    public Spliterator<Double> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
