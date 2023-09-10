package foo.rida.jmh;

import org.openjdk.jmh.annotations.*;

import foo.rida.*;

import java.util.Random;

@State(Scope.Benchmark)
public class RawWrapperExecutionPlan {

    static final int size = 1_000;
    static RawWrapper[] wrappers;

    @Setup(Level.Invocation)
    public void setup() {
        wrappers = new RawWrapper[size];
        Random randomGenerator = new Random();
        for (int i = 0; i < size; i++) {
            int number = randomGenerator.nextInt();
            RawWrapper wrapper = new RawWrapper(number);
            wrappers[i] = wrapper;
        }
    }
}
