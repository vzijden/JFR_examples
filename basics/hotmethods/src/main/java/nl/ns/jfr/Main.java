package nl.ns.jfr;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static final int COUNT = 500_000;
    public static final int REPORT_EACH = 5_000;
    public static final int ITERATIONS = 20_000;

    public static void main(String[] args) {

        final List<Integer> items = IntStream.range(0, COUNT).boxed().collect(Collectors.toList());

        final Runnable runnable = () -> {
            for (int i = 0; i < ITERATIONS; i++) {
                final boolean contains = items.contains(new Random().nextInt(COUNT));
                if (!contains) {
                    throw new RuntimeException("Weird");
                }

                if (i % REPORT_EACH == 0) {
                    System.out.printf("Completed %d of %d%n", i, ITERATIONS);
                    Thread.yield();
                }
            }
        };

        for (int i = 0; i < 16; i++) {
            final Thread thread = new Thread(runnable);
            thread.start();
        }

    }


}
