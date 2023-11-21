import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCaseCount = Integer.parseInt(scanner.nextLine());
            int[] results = new int[testCaseCount];

            for (int i = 0; i < testCaseCount; i++) {
                input(scanner, results, i);
            }

            for (int result : results) {
                System.out.println(result);
            }
        }
    }

    private static void input(final Scanner scanner, final int[] results, final int i) {
        String[] inputRowsAndColumnsAndCount = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(inputRowsAndColumnsAndCount[0]);
        int columns = Integer.parseInt(inputRowsAndColumnsAndCount[1]);
        int cabbageCount = Integer.parseInt(inputRowsAndColumnsAndCount[2]);

        int[][] matrix = new int[rows][columns];
        for (int j = 0; j < cabbageCount; j++) {
            String[] inputLocation = scanner.nextLine().split(" ");
            int row = Integer.parseInt(inputLocation[0]);
            int column = Integer.parseInt(inputLocation[1]);
            matrix[row][column] = 1;
        }

        int minimumWormCount = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[0].length; k++) {
                if (matrix[j][k] == 1) {
                    minimumWormCount++;
                    markConnectedComponent(matrix, j, k);
                }
            }
        }
        results[i] = minimumWormCount;
    }


    private static void markConnectedComponent(final int[][] matrix, final int row, final int column) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length || matrix[row][column] != 1) {
            return;
        }

        matrix[row][column] = -1;

        markConnectedComponent(matrix, row - 1, column);
        markConnectedComponent(matrix, row, column + 1);
        markConnectedComponent(matrix, row + 1, column);
        markConnectedComponent(matrix, row, column - 1);
    }
}
