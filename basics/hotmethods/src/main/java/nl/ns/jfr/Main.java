package nl.ns.jfr;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static final int COUNT = 2_000_000;

    public static void main(String[] args) throws InterruptedException {

        final List<Integer> items = IntStream.range(0, COUNT).boxed().collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < COUNT - 1; i++) {
            items.remove(0);
        }


    }


}
