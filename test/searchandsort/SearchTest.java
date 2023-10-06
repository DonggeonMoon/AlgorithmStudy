package searchandsort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    @Test
    void binarySearchTest() {
        int[] input = {1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 0; i < input.length; i++) {
            int result = binarySearch(input, input[i]);
            System.out.println("The target index: " + result);
            assertEquals(i, result);
        }
    }

    private int binarySearch(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new NotFoundException();
    }

    @Test
    void interpolationSearchTest() {
        int[] input = {1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 0; i < input.length; i++) {
            int result = interpolationSearch(input, input[i]);
            System.out.println("The target index: " + result);
            assertEquals(i, result);
        }
    }

    private int interpolationSearch(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right && input[left] <= target && input[right] >= target) {
            int position = left + (target - input[left]) / (input[right] - input[left]) * (right - left);

            if (input[position] == target) {
                return position;
            }

            if (input[position] < target) {
                left = position + 1;
            } else {
                right = position - 1;
            }
        }
        throw new NotFoundException();
    }

    @Test
    void hashSearchTest() {
        String[] inputKeys = {"사과", "바나나", "오렌지", "포도"};
        int[] inputValues = {50, 30, 20, 40};

//        int result = hashSearch(input, input[3]);
//        System.out.println("The target index: " + result);


        for (int i = 0; i < inputKeys.length; i++) {
            int result = hashSearch(inputKeys, inputValues, inputKeys[i]);
            System.out.println("The target index: " + result);
            assertEquals(inputValues[i], result);
        }
    }

    private int hashSearch(String[] inputKeys, int[] inputValues, String target) {
        HashTable hashTable = new HashTable(inputKeys, inputValues);

        return hashTable.get(target);
    }

    static class HashTable {
        final int DEFAULT_ARRAY_SIZE = 100;
        String[] keys;
        int[] values;

        HashTable(String[] inputKeys, int[] inputValues) {
            keys = new String[DEFAULT_ARRAY_SIZE];
            values = new int[DEFAULT_ARRAY_SIZE];
            for (int i = 0; i < inputKeys.length; i++) {
                put(inputKeys[i], inputValues[i]);
            }
        }

        private int hash(String key) {
            return Math.abs(key.hashCode() % DEFAULT_ARRAY_SIZE);
        }

        public void put(String key, int value) {
            keys[hash(key)] = key;
            values[hash(key)] = value;
        }

        public int get(String key) {
            if (key != null && keys[hash(key)].equals(key)) {
                return values[hash(key)];
            } else {
                throw new NotFoundException();
            }
        }
    }


    static class NotFoundException extends RuntimeException {
        public NotFoundException() {
            super("The target value does not exist!");
        }

    }
}
