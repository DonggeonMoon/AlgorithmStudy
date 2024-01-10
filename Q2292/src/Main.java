import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number == 1) {
            System.out.println(1);
            return;
        }

        int count = 0;
        int sum = 0;

        do {
            count++;
            sum += 6 * count;

        } while (number >= sum + 2);
        System.out.println(count + 1);
    }
}
