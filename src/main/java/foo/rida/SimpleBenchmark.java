package foo.rida;

import java.util.Random;

public class SimpleBenchmark {

    public static void main(String[] args) {
        final int benchmarkSize = 10_000_000;


        RawWrapper[] rawWrappers = generateRawWrappers(benchmarkSize);
        long rawWrappersStart = System.currentTimeMillis();
        int rawWrappersSum = benchmarkRawWrappers(rawWrappers);
        long rawWrappersEnd = System.currentTimeMillis();
        long rawWrappersTime = rawWrappersEnd - rawWrappersStart;
        System.out.println("raw wrappers: " + rawWrappersTime + "ms., sum: " + rawWrappersSum);


        GetterWrapper[] getterWrappers = generateGetterWrappers(benchmarkSize);
        long getterWrappersStart = System.currentTimeMillis();
        int getterWrappersSum = benchmarkGetterWrappers(getterWrappers);
        long getterWrappersEnd = System.currentTimeMillis();
        long getterWrappersTime = getterWrappersEnd - getterWrappersStart;
        System.out.println("getter wrappers: " + getterWrappersTime + "ms., sum: " + getterWrappersSum);


        ParentGetterWrapper[] virtualGetterWrappers = generateVirtualGetterWrappers(benchmarkSize);
        long virtualGetterWrappersStart = System.currentTimeMillis();
        int virtualGetterWrappersSum = benchmarkVirtualGetterWrappers(virtualGetterWrappers);
        long virtualGetterWrappersEnd = System.currentTimeMillis();
        long virtualGetterWrappersTime = virtualGetterWrappersEnd - virtualGetterWrappersStart;
        System.out.println("virtual getter wrappers: " + virtualGetterWrappersTime + "ms., sum: " + virtualGetterWrappersSum);
    }

    public static RawWrapper[] generateRawWrappers(int benchmarkSize) {
        RawWrapper[] wrappers = new RawWrapper[benchmarkSize];
        Random randomGenerator = new Random();
        for (int i = 0; i < benchmarkSize; i++) {
            int number = randomGenerator.nextInt();
            RawWrapper wrapper = new RawWrapper(number);
            wrappers[i] = wrapper;
        }
        return wrappers;
    }

    public static GetterWrapper[] generateGetterWrappers(int benchmarkSize) {
        GetterWrapper[] wrappers = new GetterWrapper[benchmarkSize];
        Random randomGenerator = new Random();
        for (int i = 0; i < benchmarkSize; i++) {
            int number = randomGenerator.nextInt();
            GetterWrapper wrapper = new GetterWrapper(number);
            wrappers[i] = wrapper;
        }
        return wrappers;
    }

    public static ParentGetterWrapper[] generateVirtualGetterWrappers(int benchmarkSize) {
        ParentGetterWrapper[] wrappers = new ParentGetterWrapper[benchmarkSize];
        Random randomGenerator = new Random();
        for (int i = 0; i < benchmarkSize; i++) {
            int number = randomGenerator.nextInt();
            int coinToss = randomGenerator.nextInt(2);
            ParentGetterWrapper wrapper;
            if (coinToss == 0) {
                wrapper = new ParentGetterWrapper(number);
            } else {
                wrapper = new ChildGetterWrapper(number);
            }
            wrappers[i] = wrapper;
        }
        return wrappers;
    }

    private static int benchmarkRawWrappers(RawWrapper[] wrappers) {
        int sum = 0;
        for (RawWrapper wrapper : wrappers) {
            sum += wrapper.number;
        }
        return sum;
    }

    private static int rawWrapperAdd(RawWrapper wrapper, int sum) {
        int number = wrapper.number;
        sum += number;
        return sum;
    }

    private static int benchmarkGetterWrappers(GetterWrapper[] wrappers) {
        int sum = 0;
        for (GetterWrapper wrapper : wrappers) {
            sum += wrapper.getNumber();
        }
        return sum;
    }

    private static int getterWrapperAdd(GetterWrapper wrapper, int sum) {
        int number = wrapper.getNumber();
        sum += number;
        return sum;
    }

    private static int benchmarkVirtualGetterWrappers(ParentGetterWrapper[] wrappers) {
        int sum = 0;
        for (ParentGetterWrapper wrapper : wrappers) {
            sum += wrapper.getNumber();
        }
        return sum;
    }

    private static int virtualGetterWrapperAdd(ParentGetterWrapper wrapper, int sum) {
        int number = wrapper.getNumber();
        sum += number;
        return sum;
    }
}