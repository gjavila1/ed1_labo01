package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    // QuickSort con el último elemento como pivote
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "high");
    }

    // QuickSort con el primer elemento como pivote
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "low");
    }

    // QuickSort con un pivote aleatorio
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "random");
    }

    // Método principal de QuickSort que selecciona el pivote según la estrategia
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, String pivotType) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, pivotType);
            quickSort(array, low, pivotIndex - 1, pivotType);
            quickSort(array, pivotIndex + 1, high, pivotType);
        }
    }

    // Partición del array según el tipo de pivote
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, String pivotType) {
        int pivotIndex = switch (pivotType) {
            case "low" -> low;              // Primer elemento como pivote
            case "random" -> new Random().nextInt(high - low + 1) + low; // Pivote aleatorio
            default -> high;                 // Último elemento como pivote (por defecto)
        };

        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, high); // Mover el pivote al final

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivotValue) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high); // Mover el pivote a su posición final
        return i + 1;
    }

    // Intercambia dos elementos en el array
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}