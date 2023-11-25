import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = scanner.nextInt();

            System.out.println(FibonacciNumber.from(inputNumber));
        }
    }

    private static class FibonacciNumber {
        public static int from(int number) {
            return filterZeroOrOne(number, new int[plusOne(number)]);
        }

        private static int plusOne(int number) {
            return number + 1;
        }

        private static int filterZeroOrOne(int number, int[] memo) {
            return zeroOrOne(number) ? number : filterCached(number, memo);
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

        private static int filterCached(final int number, final int[] memo) {
            return cached(number, memo) ? memo[number] : getFibonacci(number, memo);
        }

        private static boolean cached(final int number, final int[] memo) {
            return memo[number] != 0;
        }

        private static int getFibonacci(final int number, final int[] memo) {
            int value = combineFibonacciNumber(number, memo);
            cache(number, memo, value);
            return value;
        }

        private static int combineFibonacciNumber(final int number, final int[] memo) {
            return filterZeroOrOne(minusTwo(number), memo) + filterZeroOrOne(minusOne(number), memo);
        }

        private static int minusTwo(final int number) {
            return number - 2;
        }

        private static int minusOne(final int number) {
            return number - 1;
        }

        private static void cache(final int number, final int[] memo, final int value) {
            memo[number] = value;
        }
    }
}
