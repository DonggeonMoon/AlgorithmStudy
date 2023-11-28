import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int stepCount = scanner.nextInt();
            int[] maximumScores = new int[addOneTo(stepCount)];
            int[] stepScores = new int[addOneTo(stepCount)];
            maximumScores[0] = 0;
            processCaseOfOne(stepCount, scanner, stepScores, maximumScores);
            processCaseOfTwo(stepCount, scanner, stepScores, maximumScores);
            for (int i = 3; i <= stepCount; i++) {
                int inputScore = scanner.nextInt();
                stepScores[i] = inputScore;
                maximumScores[i] = Math.max(sum(maximumScores[subtractTwoFrom(i)], stepScores[i]), sum(maximumScores[subtractThreeFrom(i)], stepScores[subtractOneFrom(i)], stepScores[i]));
            }
            System.out.println(maximumScores[stepCount]);
        }
    }

    private static void processCaseOfOne(final int stepCount, final Scanner scanner, final int[] stepScores, final int[] maximumScores) {
        if (stepCount >= 1) {
            int firstScore = scanner.nextInt();
            stepScores[1] = firstScore;
            maximumScores[1] = sum(maximumScores[subtractOneFrom(1)], stepScores[1]);
        }
    }

    private static void processCaseOfTwo(final int stepCount, final Scanner scanner, final int[] stepScores, final int[] maximumScores) {
        if (stepCount >= 2) {
            int secondScore = scanner.nextInt();
            stepScores[2] = secondScore;
            maximumScores[2] = sum(maximumScores[subtractOneFrom(2)], stepScores[2]);
        }
    }

    private static int sum(final int... args) {
        return Arrays.stream(args).sum();
    }

    private static int addOneTo(final int stepCount) {
        return stepCount + 1;
    }

    private static int subtractOneFrom(final int i) {
        return i - 1;
    }

    private static int subtractTwoFrom(final int i) {
        return i - 2;
    }

    private static int subtractThreeFrom(final int i) {
        return i - 3;
    }
}
