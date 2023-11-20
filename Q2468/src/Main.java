import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] input = scanner.nextLine().split(" ");
                for (int j = 0; j < input.length; j++) {
                        matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            int maximumHeight = getMaximumHeight(matrix);

            int maximumCount = 0;
            for (int i = 0; i <= maximumHeight; i++) {
                int safeAreaCount = getSafeAreaCount(matrix, i);
                if (safeAreaCount > maximumCount) {
                    maximumCount = safeAreaCount;
                }
            }

            System.out.println(maximumCount);
        }
    }

    private static int getSafeAreaCount(final int[][] matrix, final int height) {
        int[][] newMatrix = deepCopy(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                if (newMatrix[i][j] > height) {
                    newMatrix[i][j] = 1;
                    continue;
                }
                newMatrix[i][j] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                if (newMatrix[i][j] == 1) {
                    count++;
                    markConnectedComponent(newMatrix, i, j);
                }
            }
        }
        return count;
    }

    private static void markConnectedComponent(final int[][] newMatrix, final int row, final int column) {
        if (row < 0 || row >= newMatrix.length || column < 0 || column >= newMatrix.length || newMatrix[row][column] != 1) {
            return;
        }
        newMatrix[row][column] = -1;

        markConnectedComponent(newMatrix, row - 1, column);
        markConnectedComponent(newMatrix, row, column + 1);
        markConnectedComponent(newMatrix, row + 1, column);
        markConnectedComponent(newMatrix, row, column - 1);
    }

    private static int getMaximumHeight(final int[][] matrix) {
        int maximum = 0;
        for (final int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (maximum < ints[j]) {
                    maximum = ints[j];
                }
            }
        }
        return maximum;
    }

    private static int[][] deepCopy(final int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix.length; j++) {

            newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
