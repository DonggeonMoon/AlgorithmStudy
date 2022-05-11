package practice.kakao20220501;

public class main {

    public static void main(String[] args) {
        String s1 = "가";
        String s2 = "가";
        String s3 = new String("가");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));

        System.out.println("s1.hashCode() = " + s1.hashCode());
        System.out.println("s2.hashCode() = " + s2.hashCode());
    }
}
