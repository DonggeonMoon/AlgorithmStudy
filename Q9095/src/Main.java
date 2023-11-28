import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] answers;
    private static int[] memo;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCaseCount = scanner.nextInt();
            answers = createAnswerTable();
            findAnswer(testCaseCount, scanner);
            Arrays.stream(memo).forEach(System.out::println);
        }
    }

    private static int[] createAnswerTable() {
        answers = new int[11];
        answers[0] = 1;
        answers[1] = 2;
        answers[2] = 4;
        for (int i = 3; i < answers.length; i++) {
            answers[i] = answers[subtractOneFrom(i)] + answers[subtractTwoFrom(i)] + answers[subtractThreeFrom(i)];
        }
        return answers;
    }

    private static int subtractOneFrom(final int number) {
        return number - 1;
    }

    private static int subtractTwoFrom(final int number) {
        return number - 2;
    }

    private static int subtractThreeFrom(final int number) {
        return number - 3;
    }

    private static void findAnswer(final int testCaseCount, final Scanner scanner) {
        memo = new int[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            int number = scanner.nextInt();
            memo[i] = answers[subtractOneFrom(number)];
        }
    }
}