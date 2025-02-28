package ed.lab;

import java.util.Random;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = (int length) -> {

        String[] array = new String[length];
        for(int i = 0; i<length ; i++ ){

            array[i] = String.valueOf(i);
        }
        return array;
    };

    ///


    private static final ArrayGenerator<String> invertedArrayGenerator = (int length) -> {

        String[] array = new String[length];
        for(int i = 0; i<length ; i++){

            array[i] = String.valueOf(length-1-i);
        }
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = (int length) -> {
        Random random = new Random();
        String[] array = new String[length];
        for(int i = 0; i<length ; i++){

            array[i] = String.valueOf(random.nextInt(100));
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort =  array -> SortingAlgorithms.highPivotQuickSort(array); // Reemplácelo por una referencia a un método

    private static final QuickSort<String> lowPivotQuickSort = array -> SortingAlgorithms.lowPivotQuickSort(array); // Reemplácelo por una referencia a un método

    private static final QuickSort<String> randomPivotQuickSort = array -> SortingAlgorithms.randomPivotQuickSort(array); // Reemplácelo por una referencia a un método

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();
//.
        System.out.println("Ordenando un arreglo ordenado: ");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");


    }
}
