import java.util.Scanner;

public class Main {
    static long[] memo;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = scanner.nextInt();
            memo = new long[inputNumber + 1];
            System.out.println(fibonacci(inputNumber));
        }
    }

    private static long fibonacci(final long inputNumber) {
        if (inputNumber == 0) {
            return 0;
        }
        if (inputNumber == 1) {
            return 1;
        }
        if (memo[(int) inputNumber] != 0) {
            return memo[(int) inputNumber];
        }
        long result = fibonacci(inputNumber - 1) + fibonacci(inputNumber - 2);
        memo[(int) inputNumber] = result;
        return result;
    }
}
