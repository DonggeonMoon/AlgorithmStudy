public class InterpolationSearch implements Search {
    @Override
    public int search(int[] input, int target) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high && target >= input[low] && target <= input[high]) {
            if (low == high) {
                if (input[low] == target) {
                    return low;
                }
                return -1;
            }

            int pos = low + (((high - low) / (input[high] - input[low])) * (target - input[low]));

            if (input[pos] == target) {
                return pos;
            }

            if (input[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }
}
