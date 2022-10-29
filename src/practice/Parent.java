package practice;

import java.lang.reflect.Field;

public class Parent {

    private String field1;
    private String field2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String toStringField() throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder(100);
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            stringBuilder.append(field.get(this));
        }
        return stringBuilder.toString();
    }

    public void listUpFields() {
        Class cls = this.getClass();

        System.out.println(cls.getSuperclass().getName());

        for (Field field : cls.getSuperclass().getDeclaredFields()) {
            System.out.println("field.getName() = " + field.getName());
        }
        System.out.println("---------------------------");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println("field.getName() = " + field.getName());
        }
    }
}
