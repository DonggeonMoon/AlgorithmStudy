package practice.utils;

public class Utils {
    private Utils() {
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
