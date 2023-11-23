import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int result;
    static String[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] inputRowsAndColumns = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(inputRowsAndColumns[0]);
            int columns = Integer.parseInt(inputRowsAndColumns[1]);

            matrix = new String[rows][columns];

            for (int i = 0; i < rows; i++) {
                String[] inputRows = scanner.nextLine().split("");
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = inputRows[j];
                }
            }

            result = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j].equals("L")) {
                        visited = new boolean[rows][columns];
                        bfs(matrix, i, j, 0);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void bfs(final String[][] matrix, final int row, final int column, int count) {
        visited[row][column] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, column, count));
        while (!queue.isEmpty()) {
            Point node = queue.poll();

            visit(matrix, visited, queue, node.getX() + 1, node.getY(), node.getCount());
            visit(matrix, visited, queue, node.getX() - 1, node.getY(), node.getCount());
            visit(matrix, visited, queue, node.getX(), node.getY() - 1, node.getCount());
            visit(matrix, visited, queue, node.getX(), node.getY() + 1, node.getCount());
        }
    }

    private static void visit(final String[][] matrix, boolean[][] visited, Queue<Point> queue, final int row, final int column, int count
    ) {
        if (row >= 0
                && row < matrix.length
                && column >= 0
                && column < matrix[0].length
                && !visited[row][column]
                && matrix[row][column].equals("L")
        ) {
            visited[row][column] = true;
            queue.add(new Point(row, column, count + 1));
            result = Math.max(result, count + 1);
        }
    }

    static class Point {
        private final int x;
        private final int y;
        private final int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }
}
