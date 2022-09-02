package test;

public class A {
    int i;

    static String s;

    void method1() {
    }

    static void method2() {
    }

    public static void main(String[] args) {
        String str1 = "hello";

//        String str2="he"+ new String("llo");
//        String str2="he"+ "llo";
        String str2 = new String("he") + "llo";

        System.out.println(str1 == str2);

    }

}
