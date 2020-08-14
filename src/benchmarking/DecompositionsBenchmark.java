package benchmarking;

import main.java.com.jatrix.Matrices;
import main.java.com.jatrix.Matrix;
import main.java.com.jatrix.decomposition.LUDecomposition;
import main.java.com.jatrix.decomposition.LUPDecomposition;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DecompositionsBenchmark {
//    @Param({"32","64","256","512","1024"})
    int N;

    private Matrix A;


    @Setup(Level.Invocation)
    public void prepare() {
        A = new Matrix(new double[][]{
                {15,5,0,0,8,4,-6,3,2,1},
                {2,5,6,8,-6,12,11,10,10,-7},
                {7,8,1,-6,12,-8,7,7,6,10},
                {3,9,8,-1,-9,9,9,1,12,11},
                {1,0,0,-5,4,5,7,4,3,4},
                {15,12,-4,3,3,10,17,9,9,-1},
                {10,0,13,-5,4,5,7,4,3,8},
                {1,1,0,-15,4,5,17,4,13,4},
                {-9,12,-19,-5, -16, 15,7,4,3,4},
                {0,-9,0,-5,4,-2,17,4,13,4},
        });
    }


    @Benchmark
    public double lupDeterminantBenchmark() {
        return new LUPDecomposition(A).det();
    }

    @Benchmark
    public double luDeterminantBenchmark() {
        return new LUDecomposition(A).det();
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(DecompositionsBenchmark.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
