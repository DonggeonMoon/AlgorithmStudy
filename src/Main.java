import practice.Child;
import practice.Parent;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Parent parent = new Parent();
        parent.setField1("1번");
        parent.setField2("2번");

        Child child = new Child();

        child.setField1("1번");
        child.setField2("2번");
        child.setField3("3번");

        System.out.println("ㅇㅁㄹ");
        System.out.println(":" + child.toStringField());
    }
}
