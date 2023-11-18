import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCaseCount = Integer.parseInt(scanner.nextLine());
            int[] results = new int[testCaseCount];

            for (int i = 0; i < testCaseCount; i++) {
                int minimumCount = 0;
                String input = scanner.nextLine();
                String[] points = input.split(" ");

                int xOfDeparturePoint = Integer.parseInt(points[0]);
                int yOfDeparturePoint = Integer.parseInt(points[1]);
                int xOfDestinationPoint = Integer.parseInt(points[2]);
                int yOfDestinationPoint = Integer.parseInt(points[3]);

                int planetarySystemCount = Integer.parseInt(scanner.nextLine());

                for (int j = 0; j < planetarySystemCount; j++) {
                    String[] centerAndRadius = scanner.nextLine().split(" ");
                    int xOfCenter = Integer.parseInt(centerAndRadius[0]);
                    int yOfCenter = Integer.parseInt(centerAndRadius[1]);
                    int radius = Integer.parseInt(centerAndRadius[2]);

                    double distance1 = Math.sqrt((Math.pow(xOfDeparturePoint - xOfCenter, 2) + Math.pow(yOfDeparturePoint - yOfCenter, 2)));
                    double distance2 = Math.sqrt(Math.pow(xOfDestinationPoint - xOfCenter, 2) + Math.pow(yOfDestinationPoint - yOfCenter, 2));

                    if (distance1 > radius && distance2 > radius) {
                        continue;
                    }

                    if (distance1 < radius) {
                        minimumCount++;
                    }

                    if (distance2 < radius) {
                        minimumCount++;
                    }

                    if (distance1 < radius && distance2 < radius) {
                        minimumCount -= 2;
                    }
                }
                results[i] = minimumCount;
            }

            for (int i : results) {
                System.out.println(i);
            }
        }
    }
}
