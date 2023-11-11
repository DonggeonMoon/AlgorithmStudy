import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int j : array) {
            System.out.println(getZeroAndOneCountMessageOf(j));
        }
    }

    public static String getZeroAndOneCountMessageOf(int n) {
        int[] memo = new int[n];
        return fibonacci(n - 1, memo) + " " + fibonacci(n, memo);
    }

    public static int fibonacci(int n, int[] memo) {
        if (n == -1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            memo[n - 1] = 1;
            return 1;
        } else {
            if (memo[n - 1] != 0) {
                return memo[n - 1];
            }
            int fibonacci = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            memo[n - 1] = fibonacci;
            return fibonacci;
        }
    }
}