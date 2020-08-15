package benchmarking;

import main.java.com.jatrix.Matrices;
import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.StrassenProduct;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Warmup(iterations = 15)
@Measurement(iterations = 15)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MultiplyingBenchmarking {
    @Param({"10000"})
    int N;

    private Matrix A;
    private Matrix B;


    @Setup(Level.Invocation)
    public void prepare() {
        A = new Matrix(N);
        B = new Matrix(N);
        Matrices.fillRandom(A);
        Matrices.fillRandom(B);
    }

//    @Benchmark
//    public Matrix defaultMultiplicationBenchmark() {
//        return Matrices.multiply(A, B);
//    }

    @Benchmark
    public Matrix StrassenProductBenchmark() {
        return StrassenProduct.mul(A, B);
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(MultiplyingBenchmarking.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
