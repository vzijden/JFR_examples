package nl.ns.jfr;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static final int COUNT = 1_000_000;
    public static final int REPORT_EACH = COUNT / 6;

    public static void main(String[] args) {

        final List<Integer> items = IntStream.range(0, COUNT).boxed().collect(Collectors.toList());

        for (int i = 0; i < COUNT - 1; i++) {
            items.remove(0);

            if (i % REPORT_EACH == 0) {
                System.out.println("Removed " + i + " of " + COUNT);
            }
        }


        System.out.println("Done");
    }


}
