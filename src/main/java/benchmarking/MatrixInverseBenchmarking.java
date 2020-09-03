package benchmarking;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


public class MatrixInverseBenchmarking {
    @Param({"1024"})
    public int N;


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(MatrixInverseBenchmarking.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
