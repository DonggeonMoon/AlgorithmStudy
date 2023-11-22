import java.util.Scanner;

public class Main {
    private static int result;
    private static int count;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] inputRowAndColumn = scanner.nextLine().split(" ");
            int row = Integer.parseInt(inputRowAndColumn[0]);
            int column = Integer.parseInt(inputRowAndColumn[1]);

            String[][] matrix = new String[row][column];

            for (int i = 0; i < row; i++) {
                String[] inputRow = scanner.nextLine().split("");
                System.arraycopy(inputRow, 0, matrix[i], 0, column);
            }
            System.out.println(findMaximumCount(matrix));
        }
    }

    private static int findMaximumCount(final String[][] matrix) {
        boolean[] visited = new boolean[26];
        count = 0;
        result = 1;
        dfs(matrix, visited, 0, 0);
        return result;
    }

    private static void dfs(final String[][] matrix, boolean[] visited, final int row, final int column) {
        if (visited[getIndex(matrix, row, column)]) {
            result = Math.max(result, count);
            return;
        }

        visited[getIndex(matrix, row, column)] = true;
        count++;
        visit(matrix, visited, row - 1, column);
        visit(matrix, visited, row, column + 1);
        visit(matrix, visited, row + 1, column);
        visit(matrix, visited, row, column - 1);

        count--;
        visited[getIndex(matrix, row, column)] = false;
    }

    private static void visit(final String[][] matrix, final boolean[] visited, final int row, final int column) {
        if (row >= 0
                && row < matrix.length
                && column >= 0
                && column < matrix[0].length) {
            dfs(matrix, visited, row, column);
        }
    }

    private static int getIndex(final String[][] matrix, int row, int column) {
        return matrix[row][column].charAt(0) - 'A';
    }
}