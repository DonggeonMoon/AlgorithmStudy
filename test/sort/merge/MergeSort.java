package sort.merge;

import sort.Sort;

import java.util.Arrays;

public class MergeSort extends Sort {
    private MergeSort() {
    }

    public static MergeSort create() {
        return new MergeSort();
    }

    @Override
    public void sort(final int[] numbers) {
        int length = numbers.length;
        if (length <= 1) {
            return;
        }

        int mid = length / 2;

        int[] group1 = Arrays.copyOfRange(numbers, 0, mid);
        int[] group2 = Arrays.copyOfRange(numbers, mid, length);

        sort(group1);
        sort(group2);

        int groupIndex1 = 0;
        int groupIndex2 = 0;
        int numberIndex = 0;

        while (groupIndex1 < group1.length && groupIndex2 < group2.length) {
            if (group1[groupIndex1] < group2[groupIndex2]) {
                numbers[numberIndex] = group1[groupIndex1];
                groupIndex1++;
                numberIndex++;
                continue;
            }
            numbers[numberIndex] = group2[groupIndex2];
            groupIndex2++;
            numberIndex++;
        }

        while (groupIndex1 < group1.length) {
            numbers[numberIndex] = group1[groupIndex1];
            groupIndex1++;
            numberIndex++;
        }

        while (groupIndex2 < group2.length) {
            numbers[numberIndex] = group2[groupIndex2];
            groupIndex2++;
            numberIndex++;
        }
    }
}
