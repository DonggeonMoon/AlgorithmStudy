package sort.selection;

import sort.Sort;

public class SelectionSort extends Sort {
    private SelectionSort() {
    }

    public static SelectionSort create() {
        return new SelectionSort();
    }

    @Override
    public void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    swap(numbers, i, j);
                }
            }
        }
    }
}
