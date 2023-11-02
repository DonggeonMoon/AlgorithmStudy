import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String a = null;
        System.out.println("a = " + a);
    }

    public static boolean testMethod(String a) {
        return a == null;
    }
}
