import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[100];

        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) bufferedInputStream.read();
        }
        System.out.println(new String(bytes, StandardCharsets.UTF_8));


    }
}
