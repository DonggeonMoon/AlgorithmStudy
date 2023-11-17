package sort.quick;

import sort.Sort;

public class QuickSort extends Sort {
    private QuickSort() {
    }

    public static QuickSort create() {
        return new QuickSort();
    }

    @Override
    protected void sort(final int[] numbers) {
        subSort(numbers, 0, numbers.length - 1);
    }

    private void subSort(int[] numbers, int start, int end) {
        if (end - start <= 0) {
            return;
        }

        int pivot = numbers[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (numbers[j] <= pivot) {
                swap(numbers, i, j);
                i++;
            }

            swap(numbers, i, end);
        }
        subSort(numbers, start, i - 1);
        subSort(numbers, i + 1, end);
    }

}
