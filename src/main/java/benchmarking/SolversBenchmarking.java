package benchmarking;


import com.jatrix.core.Matrices;
import com.jatrix.core.Matrix;
import com.jatrix.solvers.CramerSolver;
import com.jatrix.solvers.GaussSolver;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SolversBenchmarking {
    @Param({"32"})
    private int N;
    private Matrix matrix;
    private double[] constants;

    @Setup(Level.Invocation)
    public void prepare() {
        matrix = new Matrix(N);
        Matrices.fillRandom(matrix);
        Random random = new Random();
        constants = new double[matrix.getRowDimension()];
        for (int i = 0; i < constants.length; i++) {
            constants[i] = random.nextInt(20) - 10;
        }
    }

    @Benchmark
    public double[] CramerSolverBenchmark() {
        CramerSolver cramerSolver = new CramerSolver(matrix, constants);
        return cramerSolver.getRoots();
    }

    @Benchmark
    public double[] GaussSolverBenchmark() {
        GaussSolver gaussSolver = new GaussSolver(matrix, constants);
        return gaussSolver.getRoots();
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(SolversBenchmarking.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
