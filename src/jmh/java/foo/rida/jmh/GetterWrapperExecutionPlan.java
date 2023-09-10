package foo.rida.jmh;

import org.openjdk.jmh.annotations.*;

import foo.rida.*;

import java.util.Random;

@State(Scope.Benchmark)
public class GetterWrapperExecutionPlan {

    static final int size = 1_000;
    static GetterWrapper[] wrappers;

    @Setup(Level.Invocation)
    public static void setup() {
        wrappers = new GetterWrapper[size];
        Random randomGenerator = new Random();
        for (int i = 0; i < size; i++) {
            int number = randomGenerator.nextInt();
            GetterWrapper wrapper = new GetterWrapper(number);
            wrappers[i] = wrapper;
        }
    }
}
