import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = Integer.parseInt(scanner.nextLine());
            String[] answers = new String[count];


            for (int i = 0; i < count; i++) {
                String sentence = scanner.nextLine();

                Map<String, Integer> map = new HashMap<>();
                for (int j = 0; j < sentence.length(); j++) {
                    String letter = sentence.substring(j, j + 1);
                    if (letter.equals(" ")) {
                        continue;
                    }
                    map.put(letter, map.getOrDefault(letter, 0) + 1);
                }

                String max = null;
                int maxCount = 0;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxCount) {
                        max = entry.getKey();
                        maxCount = entry.getValue();
                    }
                }

                int number = 0;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        number++;
                    }
                }


                if (max == null || " ".equals(max) || number > 1) {
                    answers[i] = "?";
                    continue;
                }

                answers[i] = max;
            }

            for (String answer : answers) {
                System.out.println(answer);
            }
        }
    }
}
