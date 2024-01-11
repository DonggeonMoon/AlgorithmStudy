import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                if ("0".equals(input)) {
                    break;
                }

                String[] numbers = input.split("");

                boolean isNotPalindrome = false;
                for (int i = 0; i < numbers.length / 2; i++) {
                    if (!numbers[i].equals(numbers[numbers.length - 1 - i])) {
                        isNotPalindrome = true;
                        break;
                    }
                }
                if (isNotPalindrome) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }
        }
    }
}
