import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();

            int count = 0;
            while (number != 0) {
                count++;
                if (String.valueOf(count).contains("666")) {
                    number--;
                }
            }
            System.out.println(count);
        }
    }
}
