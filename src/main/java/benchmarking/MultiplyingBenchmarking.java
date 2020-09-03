package benchmarking;

import com.jatrix.core.Matrices;
import com.jatrix.core.Matrix;
import com.jatrix.core.StrassenProduct;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MultiplyingBenchmarking {
    @Param({"32"})
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

    @Benchmark
    public Matrix StrassenProductBenchmark() {
        return StrassenProduct.mul(A, B);
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .resultFormat(ResultFormatType.TEXT)
                .result("src/benchmarking/bench.txt")
                .include(MultiplyingBenchmarking.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
