import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = Integer.parseInt(scanner.nextLine());
            String[] input = scanner.nextLine().split(" ");
            int[] scores = new int[number];
            int max = 0;
            for (int i = 0; i < number; i++) {
                int score = Integer.parseInt(input[i]);
                if (score > max) {
                    max = score;
                }
                scores[i] = Integer.parseInt(input[i]);
            }

            double sum = 0;
            for (int score : scores) {
                sum += ((double) score / max) * 100;
            }

            double average = sum / number;

            System.out.println(average);
        }
    }
}
