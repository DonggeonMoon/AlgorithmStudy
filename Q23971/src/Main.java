import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");

            int height = Integer.parseInt(input[0]);
            int width = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);
            int m = Integer.parseInt(input[3]);

            int x = (int) Math.ceil((float) height / (float) (n + 1));
            int y = (int) Math.ceil((float) width / (float) (m + 1));

            System.out.println(x * y);
        }
    }
}
