package sort;

import org.junit.jupiter.api.Test;
import sort.bubble.BubbleSort;
import sort.insertion.InsertionSort;
import sort.merge.MergeSort;
import sort.quick.QuickSort;
import sort.selection.SelectionSort;

import java.util.Arrays;

public class SortTest {
    @Test
    void testSelectionSort() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};

        SelectionSort selectionSort = SelectionSort.create();
        System.out.println("Before sorting: " + Arrays.toString(input));

        selectionSort.sort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    @Test
    void testInsertionSort() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};

        InsertionSort insertionSort = InsertionSort.create();

        System.out.println("Before sorting: " + Arrays.toString(input));

        insertionSort.sort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    @Test
    void testBubbleSort() {
        int[] input = {64, 34, 25, 12, 22, 11, 90};

        BubbleSort bubbleSort = BubbleSort.create();

        System.out.println("Before sorting: " + Arrays.toString(input));

        bubbleSort.sort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    @Test
    void testMergeSort() {
        int[] input = {64, 34, 25, 12, 22, 11, 10};

        MergeSort mergeSort = MergeSort.create();

        System.out.println("Before sorting: " + Arrays.toString(input));

        mergeSort.sort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }

    @Test
    void testQuickSort() {
        int[] input = {64, 34, 25, 12, 22, 11, 10};

        QuickSort quickSort = QuickSort.create();

        System.out.println("Before sorting: " + Arrays.toString(input));

        quickSort.sort(input);

        System.out.println("After sorting: " + Arrays.toString(input));
    }
}
