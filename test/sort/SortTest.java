package sort;

import org.junit.jupiter.api.Test;
import sort.merge.MergeSort;

import java.util.Arrays;

public class SortTest {
    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    @Test
    void bubbleSortTest() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before sorting: " + Arrays.toString(input));

        bubbleSort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    private void bubbleSort(int[] input) {
        int n = input.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                }
            }
        }
    }

    @Test
    void selectionSortTest() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before sorting: " + Arrays.toString(input));

        selectionSort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    private void selectionSort(int[] input) {
        int n = input.length;

        for (int i = 0; i < n - 1; i++) {
            int minimumIndex = i;

            for (int j = i; j < n; j++) {
                if (input[j] < input[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            if (minimumIndex != i) {
                swap(input, i, minimumIndex);
            }
        }
    }

    @Test
    void insertionSortTest() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before sorting: " + Arrays.toString(input));

        insertionSort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    private void insertionSort(int[] input) {
        int n = input.length;

        for (int i = 1; i < n; i++) {
            int key = input[i];
            int j = i - 1;

            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j--;
            }

            input[j + 1] = key;
        }
    }

    @Test
    void quickSortTest() {
        int[] input = {64, 34, 25, 12, 22, 11, 10};

        System.out.println("Before sorting: " + Arrays.toString(input));

        quickSort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    private void quickSort(int[] input) {
        quickSortRecursive(input, 0, input.length - 1);
    }

    private void quickSortRecursive(int[] input, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(input, low, high);
            quickSortRecursive(input, low, pivotIndex - 1);
            quickSortRecursive(input, pivotIndex + 1, high);
        }
    }

    private int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input[j] < pivot) {
                i++;
                System.out.println("    i = " + i);
                System.out.println("    i value has changed.");
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
            System.out.println("j = " + j);
            System.out.println("input = " + Arrays.toString(input));
        }

        int temp = input[i + 1];
        input[i + 1] = input[high];
        input[high] = temp;

        return i + 1;
    }

    @Test
    void mergeSortTest() {
        MergeSort mergeSort = new MergeSort();
        int[] input = {64, 34, 25, 12, 22, 11, 10};

        mergeSort.sort(input);

        System.out.println(Arrays.toString(input));
    }
}
