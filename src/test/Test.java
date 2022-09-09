package test;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String args[]) throws InterruptedException {
        A a = new A();
        System.out.println(a.i);
        a.method1();
        A.method2();


    }

}
