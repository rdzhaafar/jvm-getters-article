package foo.rida.jmh;

import org.openjdk.jmh.annotations.*;

import foo.rida.*;

import java.util.Random;

@State(Scope.Benchmark)
public class VirtualGetterWrapperExecutionPlan {

    static final int size = 1_000;
    static ParentGetterWrapper[] wrappers;

    @Setup(Level.Invocation)
    public static void setup() {
        wrappers = new ParentGetterWrapper[size];
        Random randomGenerator = new Random();
        for (int i = 0; i < size; i++) {
            int number = randomGenerator.nextInt();
            int coin = randomGenerator.nextInt(2);
            ParentGetterWrapper wrapper;
            if (coin == 0) {
                wrapper = new ChildGetterWrapper(number);
            } else {
                wrapper = new ParentGetterWrapper(number);
            }
            wrappers[i] = wrapper;
        }
    }

}
