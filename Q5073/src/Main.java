import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> outputs = new ArrayList<>();
            while (true) {
                String[] input = scanner.nextLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int z = Integer.parseInt(input[2]);

                if (x == 0 && y == 0 && z == 0) {
                    break;
                }

                if ((x > y && x > z && x >= y + z)
                        || (y > z && y > x && y >= x + z)
                        || (z > x && z > y && z >= x + y)) {
                    outputs.add("Invalid");
                    continue;
                }

                if (x == y && y == z) {
                    outputs.add("Equilateral");
                    continue;
                }
                if (x == y || y == z || z == x) {
                    outputs.add("Isosceles");
                    continue;
                }
                outputs.add("Scalene");
            }
            for (String output : outputs) {
                System.out.println(output);
            }
        }
    }
}
