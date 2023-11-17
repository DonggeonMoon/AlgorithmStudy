package palindrome;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

public class Palindrome {
    public static final String REGEX = "[A-z가-힣]?";
    public static final String DELIMITER = "";

    private Palindrome() {
    }

    public static Palindrome create() {
        return new Palindrome();
    }

    public boolean isPalindrome(String string) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        Arrays.stream(string.split(DELIMITER))
                .filter(it -> {
                    Pattern pattern = Pattern.compile(REGEX);
                    return pattern.matcher(it).matches();
                })
                .forEach(it -> {
                    String lowerCase = it.toLowerCase();
                    queue.add(lowerCase);
                    stack.push(lowerCase);
                });

        for (int i = 0; i < queue.size(); i++) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
}
