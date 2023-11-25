import java.util.Scanner;

public class Main {
    private static final int MOD = 1000000;
    private static final int CYCLE = 15 * (MOD / 10);
    private static final int[] memo = new int[CYCLE];

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long inputNumber = scanner.nextLong();

            setMemo();
            int index = (int) (inputNumber % CYCLE);

            System.out.println(memo[index]);
        }
    }

    private static void setMemo() {
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < CYCLE; i++) {
            memo[i] = calculate(i);
        }
    }

    private static int calculate(final int i) {
        return sum(memo[minusOneFrom(i)], memo[minusTwoFrom(i)]) % MOD;
    }

    public static int sum(int augend, int addend) {
        return augend + addend;
    }

    private static int minusOneFrom(final int i) {
        return i - 1;
    }

    private static int minusTwoFrom(final int i) {
        return i - 2;
    }
}
