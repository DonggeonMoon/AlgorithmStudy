import java.util.Scanner;

public class Main {
    private static int[] memo;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = scanner.nextInt();
            memo = new int[inputNumber + 1];
            for (int i = 2; i <= inputNumber; i++) {
                calculate(i);
            }
            System.out.println(memo[inputNumber]);
        }
    }

    private static void calculate(final int i) {
        memo[i] = addOneFrom(memo[subtractOneFrom(i)]);

        if (modThree(i)) {
            memo[i] = Math.min(addOneFrom(memo[divideByThreeFrom(i)]), memo[i]);
        }

        if (modTwo(i)) {
            memo[i] = Math.min(addOneFrom(memo[divideByTwoFrom(i)]), memo[i]);
        }
    }

    private static boolean modThree(final int i) {
        return i % 3 == 0;
    }

    private static boolean modTwo(final int i) {
        return i % 2 == 0;
    }

    private static int subtractOneFrom(final int i) {
        return i - 1;
    }

    private static int addOneFrom(final int i) {
        return i + 1;
    }

    private static int divideByTwoFrom(final int i) {
        return i / 2;
    }

    private static int divideByThreeFrom(final int i) {
        return i / 3;
    }
}
