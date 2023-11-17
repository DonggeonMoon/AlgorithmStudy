package sort.bubble;

import sort.Sort;

public class BubbleSort extends Sort {
    @Override
    public void sort(final int[] numbers) {
        int length = numbers.length;

        while (true) {
            boolean swapped = false;
            for (int j = 0; j < length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                    swapped = true;
                }
            }
            if (swapped) {
                break;
            }
        }
    }
}
