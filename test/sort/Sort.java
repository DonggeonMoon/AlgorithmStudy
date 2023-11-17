package sort;

public abstract class Sort {
    protected final void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    protected abstract void sort(int[] numbers);
}
