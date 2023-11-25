import java.util.Scanner;

public class Main {
    private static int[] memo;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = scanner.nextInt();
            memo = new int[inputNumber + 1];
            System.out.println(filterZeroOrOne(inputNumber));
        }
    }

    private static int filterZeroOrOne(final int number) {
        if (zeroOrOne(number)) {
            return number;
        }
        return filterCached(number);
    }

    private static int filterCached(final int number) {
        if (cached(number)) {
            return memo[number];
        }
        return getFibonacci(number);
    }

    private static int getFibonacci(final int number) {
        int result = sum(filterZeroOrOne(subtractOneFrom(number)), filterZeroOrOne(subtractTwoFrom(number)));
        memo[number] = result;
        return result;
    }

    private static int sum(final int augend, final int addend) {
        return augend + addend;
    }

    private static int subtractOneFrom(final int number) {
        return number - 1;
    }

    private static int subtractTwoFrom(final int number) {
        return number - 2;
    }

    private static boolean cached(final int number) {
        return memo[number] != 0;
    }

    private static boolean zeroOrOne(final int number) {
        return zero(number) || one(number);
    }

    private static boolean zero(final int number) {
        return number == 0;
    }

    private static boolean one(final int number) {
        return number == 1;
    }
}
