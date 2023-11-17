package sort;

public abstract class Sort {
    protected final void swap(final int[] numbers, final int first, final int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

    public abstract void sort(final int[] numbers);
}
