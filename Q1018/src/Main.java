import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int column = Integer.parseInt(input[1]);
            String[][] matrix = new String[row][column];
            for (int i = 0; i < row; i++) {
                String[] inputRow = scanner.nextLine().split("");
                System.arraycopy(inputRow, 0, matrix[i], 0, column);
            }
            int minimumCount = Integer.MAX_VALUE;

            for (int i = 0; i <= row - 8; i++) {
                for (int j = 0; j <= column - 8; j++) {
                    int count = 0;
                    int count1 = 0;
                    int count2 = 0;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (((k % 2 == 0) ^ (l % 2 == 0)) && "W".equals(matrix[i + k][j + l])) {
                                count1++;
                            }
                            if ((k % 2 == 0) == (l % 2 == 0) && "B".equals(matrix[i + k][j + l])) {
                                count1++;
                            }

                            if (((k % 2 == 0) ^ (l % 2 == 0)) && "B".equals(matrix[i + k][j + l])) {
                                count2++;
                            }
                            if ((k % 2 == 0) == (l % 2 == 0) && "W".equals(matrix[i + k][j + l])) {
                                count2++;
                            }
                            count = Math.min(count1, count2);
                        }
                    }

                    if (count < minimumCount) {
                        minimumCount = count;
                    }
                }
            }
            System.out.println(minimumCount);
        }
    }
}
