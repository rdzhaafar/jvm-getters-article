package foo.rida.jmh;

import org.openjdk.jmh.annotations.*;

import foo.rida.*;

import java.util.concurrent.TimeUnit;

public class JmhBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static int benchmarkRawWrappers(RawWrapperExecutionPlan plan) {
        RawWrapper[] wrappers = plan.wrappers;
        int sum = 0;
        for (RawWrapper wrapper : wrappers) {
            sum += wrapper.number;
        }
        return sum;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static int benchmarkGetterWrappers(GetterWrapperExecutionPlan plan) {
        GetterWrapper[] wrappers = plan.wrappers;
        int sum = 0;
        for (GetterWrapper wrapper : wrappers) {
            sum += wrapper.getNumber();
        }
        return sum;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static int benchmarkVirtualGetterWrappers(VirtualGetterWrapperExecutionPlan plan) {
        ParentGetterWrapper[] wrappers = plan.wrappers;
        int sum = 0;
        for (ParentGetterWrapper wrapper : wrappers) {
            sum += wrapper.getNumber();
        }
        return sum;
    }

}
