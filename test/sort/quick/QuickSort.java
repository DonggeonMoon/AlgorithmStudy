package sort.quick;

import sort.Sort;

public class QuickSort extends Sort {
    private QuickSort() {
    }

    public static QuickSort create() {
        return new QuickSort();
    }

    @Override
    public void sort(final int[] numbers) {
        subSort(numbers, 0, numbers.length - 1);
    }

    private void subSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(numbers, low, high);

        subSort(numbers, low, pivotIndex - 1);
        subSort(numbers, pivotIndex + 1, high);
    }

    private int partition(final int[] numbers, final int low, final int high) {
        int pivot = numbers[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (numbers[j] <= pivot) {
                swap(numbers, i, j);
                i++;
            }
        }
        swap(numbers, i, high);
        return i;
    }

}
