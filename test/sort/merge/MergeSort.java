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

        int group1Index = 0;
        int group2Index = 0;
        int numbersIndex = 0;

        while (group1Index < group1.length && group2Index < group2.length) {
            if (group1[group1Index] < group2[group2Index]) {
                numbers[numbersIndex] = group1[group1Index];
                group1Index++;
                numbersIndex++;
                continue;
            }
            numbers[numbersIndex] = group2[group2Index];
            group2Index++;
            numbersIndex++;
        }

        while (group1Index < group1.length) {
            numbers[numbersIndex] = group1[group1Index];
            group1Index++;
            numbersIndex++;
        }

        while (group2Index < group2.length) {
            numbers[numbersIndex] = group2[group2Index];
            group2Index++;
            numbersIndex++;
        }
    }
}
