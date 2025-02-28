package ed.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester<T extends Comparable<T>> {
    private static final int ARRAY_SIZE = 10;
    private static final int TEST_SIZE = 1;

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort) {
        T[] array = generator.generate(ARRAY_SIZE);

        List<Long> durations = new ArrayList<>(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; i++) {
            T[] copy = Arrays.copyOf(array, array.length);

            final long startTime = System.nanoTime();

            quickSort.sort(copy);

            final long endTime = System.nanoTime();

            durations.add(endTime-startTime);
        }

        double average = durations.stream()
                .mapToLong(duration -> duration)
                .average()
                .orElse(0);



        long sum = durations.stream()
                .mapToLong(duration -> duration)
                .sum();

        System.out.println("\t\tTiempo promedio: "+ average);
        System.out.println("\t\tSuma de los promedios: " + sum);
    }

}
