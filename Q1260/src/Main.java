import java.util.*;

public class Main {
    static List<Set<Integer>> adjacentList;
    static boolean[] visited;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] inputCounts = scanner.nextLine().split(" ");
            int nodeCount = Integer.parseInt(inputCounts[0]);
            int edgeCount = Integer.parseInt(inputCounts[1]);
            int start = Integer.parseInt(inputCounts[2]);

            adjacentList = new ArrayList<>();
            for (int i = 0; i <= nodeCount; i++) {
                adjacentList.add(new TreeSet<>());
            }

            for (int j = 0; j < edgeCount; j++) {
                String[] inputNodes = scanner.nextLine().split(" ");
                int node1 = Integer.parseInt(inputNodes[0]);
                int node2 = Integer.parseInt(inputNodes[1]);

                Set<Integer> integers = adjacentList.get(node1);
                integers.add(node2);
                adjacentList.set(node1, integers);
                Set<Integer> integers2 = adjacentList.get(node2);
                integers2.add(node1);
                adjacentList.set(node2, integers2);
            }

            visited = new boolean[nodeCount + 1];

            dfs(start);
            System.out.println();
            visited = new boolean[nodeCount + 1];
            Queue<Integer> queue = new LinkedList<>();
            bfs(queue, start);
        }
    }

    private static void dfs(final int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int element : adjacentList.get(start)) {
            if (!visited[element]) {
                dfs(element);
            }
        }
    }

    private static void bfs(Queue<Integer> queue, final int start) {
        visited[start] = true;

        queue.add(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int element : adjacentList.get(currentNode)) {
                if (!visited[element]) {
                    visited[element] = true;
                    queue.add(element);
                }
            }
        }
    }
}
