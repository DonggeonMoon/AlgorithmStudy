package practice;

import static practice.utils.Utils.println;
import static practice.utils.Utils.sleep;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            println("i = " + i);
            sleep(1000);
        }
    }
}
