package search.binary;

import search.Search;
import sort.Sort;

import java.util.NoSuchElementException;

public class BinarySearch extends Search {
    private final Sort sort;

    private BinarySearch(final Sort sort) {
        this.sort = sort;
    }

    public static BinarySearch from(Sort sort) {
        return new BinarySearch(sort);
    }

    @Override
    public int search(final int[] numbers, final int target) {
        sort.sort(numbers);

        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == numbers[mid]) {
                return mid;
            }

            if (target < numbers[mid]) {
                end = mid - 1;
            }

            if (target > numbers[mid]) {
                start = mid + 1;
            }
        }
        throw new NoSuchElementException();
    }
}
