package nl.ns.jfr;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final long CHECKS = 1_000_000;
    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        final List<Item> items = IntStream.range(0, 1000).mapToObj(Item::new).collect(Collectors.toList());
        final Map<Integer, Item> itemMap = items.stream().collect(Collectors.toMap(Item::getId, Function.identity()));

        final Runnable runnable = () -> {
            int count = 0;
            while (count++ < CHECKS) {
                items.forEach(item -> {
                    if (!itemMap.containsKey(item.getId())) {
                        throw new RuntimeException(item + " was not found!");
                    }
                });

                if (count % 1000 == 0) {
                    Thread.yield();
                }
            }
        };

        final List<Thread> threads = IntStream.range(0, THREAD_COUNT)
                                              .mapToObj(i -> new Thread(runnable, "JFRThread-" + i))
                                              .peek(Thread::start)
                                              .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

    }


}
