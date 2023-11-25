import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static BigInteger[] memo;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = scanner.nextInt();
            setUpCache(inputNumber);
            System.out.println(fibonacci(inputNumber));
        }
    }

    private static void setUpCache(final int inputNumber) {
        memo = new BigInteger[inputNumber + 1];
    }

    private static BigInteger fibonacci(final int number) {
        if (number == 0 || number == 1) {
            return BigInteger.valueOf(number);
        }
        if (memo[number] != null) {
            return memo[number];
        }
        BigInteger result = fibonacci(number - 1).add(fibonacci(number - 2));
        memo[number] = result;
        return result;
    }
}
