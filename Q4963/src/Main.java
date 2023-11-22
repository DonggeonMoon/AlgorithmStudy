import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean finished = false;
            while (!finished) {
                String[] inputWidthAndHeight = scanner.nextLine().split(" ");
                int width = Integer.parseInt(inputWidthAndHeight[0]);
                int height = Integer.parseInt(inputWidthAndHeight[1]);

                if (width == 0 && height == 0) {
                    finished = true;
                    continue;
                }

                int[][] matrix = new int[height][width];

                for (int i = 0; i < height; i++) {
                    String[] input = scanner.nextLine().split(" ");
                    for (int j = 0; j < width; j++) {
                        matrix[i][j] = Integer.parseInt(input[j]);
                    }
                }
                int count = 0;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (matrix[i][j] == 1) {
                            count++;
                            markConnectedComponent(matrix, i, j);
                        }
                    }
                }

                results.add(count);
            }

            for (int result : results) {
                System.out.println(result);
            }
        }
    }

    private static void markConnectedComponent(final int[][] matrix, final int row, final int column) {
        if (row < 0
                || row >= matrix.length
                || column < 0
                || column >= matrix[0].length
                || matrix[row][column] != 1
        ) {
            return;
        }
        matrix[row][column] = -1;
        markConnectedComponent(matrix, row, column - 1);
        markConnectedComponent(matrix, row + 1, column - 1);
        markConnectedComponent(matrix, row + 1, column);
        markConnectedComponent(matrix, row + 1, column + 1);
        markConnectedComponent(matrix, row, column + 1);
        markConnectedComponent(matrix, row, column + 1);
        markConnectedComponent(matrix, row - 1, column + 1);
        markConnectedComponent(matrix, row - 1, column);
        markConnectedComponent(matrix, row - 1, column - 1);
    }
}
