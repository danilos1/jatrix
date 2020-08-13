package benchmarking;

import main.java.com.jatrix.Matrices;
import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.decomposition.LUPDecomposition;
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
public class DecompositionsBenchmark {
    @Param({"32","256", "512", "1024"})
    int N;

    private Matrix A;


    @Setup(Level.Invocation)
    public void prepare() {
        A = new Matrix(N);
        Matrices.fillRandom(A);
    }


    @Benchmark
    public double lupDeterminantBenchmark() {
        return new LUPDecomposition(A).det();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(DecompositionsBenchmark.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
