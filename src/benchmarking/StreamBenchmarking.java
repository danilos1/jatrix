package benchmarking;


import main.java.com.jatrix.Matrix;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Thread)
public class StreamBenchmarking {
    @Param({"1024"})
    private int N;
    private Matrix matrix;


    @Setup(Level.Invocation)
    public void prepare() {
        matrix = new Matrix(N, N, 5);
    }

    @Benchmark
    public double sumWithStreamsBenchmark() {
        return matrix.stream().sum();
    }

    @Benchmark
    public double sumWithForCycleBenchmark() {
        double sum = 0;
        double[][] m = matrix.getMatrix();
        int rows = m.length;
        int cols = m[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum+=m[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(StreamBenchmarking.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
