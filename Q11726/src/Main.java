import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = scanner.nextInt();

            long[] memo = new long[inputNumber + 1];
            memo[0] = 1;
            memo[1] = 1;

            for (int i = 2; i <= inputNumber; i++) {
                memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
            }
            System.out.println(memo[inputNumber]);
        }
    }
}
