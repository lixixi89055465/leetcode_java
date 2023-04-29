package zuo.intermediate.class01;

public class Problem05_Rand5ToRand7 {
    private static int f() {
        return 0;

    }

    //等概率返回0和1的函数
    public static int r01() {
        int res = 0;
        do {
            f();
        } while (res == 3);
        return res;
    }

    public static int g() {
        int res = 0;
        do {
            res = (r01() << 2) + (r01() << 1) + r01();
        } while (res == 7);
        return res + 1;
    }
}
