package practice.inflearnjavaalgorithm;


import java.util.Scanner;

public class RockScissorPaper {

    public String solution(int n, int[] a, int [] b) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i<n; i++) {
            answer.append(getWinner(a[i], b[i]));
        }
        return answer.toString();
    }

    private String getWinner(int a, int b) {
        if (a == b) {
            return "D";
        }

        if ((a == 1 && b == 3)
        || (a == 2 && b == 1)){
            return "A";
        }

        return "B";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
    }
}
