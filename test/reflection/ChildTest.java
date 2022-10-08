package reflection;

import org.junit.jupiter.api.Test;
import practice.Child;

import java.lang.reflect.Field;

public class ChildTest {
    Class cls = Child.class;
    @Test
    void reflectionTest() {

        for (Field field : cls.getSuperclass().getDeclaredFields()) {
            System.out.println("field.getName() = " + field.getName());
        }

        for (Field field : cls.getDeclaredFields()) {
            System.out.println("field.getName() = " + field.getName());
        }
    }
}
