package sort.selection;

import sort.Sort;

public class SelectionSort extends Sort {
    private SelectionSort() {
    }

    public static SelectionSort create() {
        return new SelectionSort();
    }

    @Override
    public void sort(int[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < inputNumbers.length; j++) {
                if (inputNumbers[j] < inputNumbers[minimumIndex]) {
                    minimumIndex = j;
                    swap(inputNumbers, i, minimumIndex);
                }
            }
            if (minimumIndex != i) {
                swap(inputNumbers, i, minimumIndex);
            }
        }
    }
}
