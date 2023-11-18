import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes;
    static int[] visited;

    public static void main(String[] args) {
        /*
        1 - <2, 3>  - 10
        2 - <4>     - 1
        3 - <4>     - 100
         */


        try (Scanner scanner = new Scanner(System.in)) {
            int testCaseCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < testCaseCount; i++) {
                String[] counts = scanner.nextLine().split(" ");
                int buildingCount = Integer.parseInt(counts[0]);
                for (int j = 0; i <buildingCount; i++) {
                    nodes.add(i, new ArrayList<>());
                }
                visited = new int[buildingCount + 1];
                int orderCount = Integer.parseInt(counts[2]);


                String[] times = scanner.nextLine().split(" ");
                for (int j = 0; j < times.length; j++) {
                    String[] input = scanner.nextLine().split(" ");
                    int buildingNumber = Integer.parseInt(input[0]);
                    int nextBuildingNumber = Integer.parseInt(input[1]);
                    nodes.get(buildingNumber).add(nextBuildingNumber);
                }


            }
        }
    }

    static void visit(int buildingNumber) {
        for (int i = 0; i < nodes.size(); i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                visit(i);
            }
        }
    }
}
