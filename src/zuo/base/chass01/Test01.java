package zuo.base.chass01;

public class Test01 {
    public static void main(String[] args) {
//        process01();
        process02();

    }

    private static void process02() {
        int N=1000;
        int a=0;
        for (int i = 0; i < N; i++) {
            a=3|6;
            a=3&4;
            a=4^785;
        }
        System.out.println(a);
    }
    private static void process01() {
        int N=1000;
        int a=0;
        for (int i = 0; i < N; i++) {
            a=2+7;
            a=4*7;
            a=6*8;
        }
        System.out.println(a);
    }
}
