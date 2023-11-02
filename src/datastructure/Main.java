package datastructure;

public class Main {
    public static void main(String[] args) {
        StackImpl strings = new StackImpl();

        strings.push("1");
        strings.push("2");
        strings.push("3");
        strings.push("4");

        System.out.println("strings = " + strings);

        System.out.println("strings.pop() = " + strings.pop());

        System.out.println("strings = " + strings);

        System.out.println("strings.peek() = " + strings.peek());

        System.out.println("strings = " + strings);

        System.out.println("strings.search(\"3\") = " + strings.search("3"));

        strings.empty();

        System.out.println("strings = " + strings);

    }
}
