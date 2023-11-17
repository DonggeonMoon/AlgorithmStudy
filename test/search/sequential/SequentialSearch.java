package search.sequential;

import java.util.NoSuchElementException;

public class SequentialSearch {
    private SequentialSearch() {
    }

    public static SequentialSearch create() {
        return new SequentialSearch();
    }

    public int search(int target, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        throw new NoSuchElementException("숫자를 찾을 수 없습니다.");
    }
}
