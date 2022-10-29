package reflection;

import org.junit.jupiter.api.Test;
import practice.Child;
import practice.Parent;

public class ChildTest {
    Parent parent = new Parent();
    Child child = new Child();

    @Test
    void reflectionTest() {
        child.listUpFields();
    }
}
