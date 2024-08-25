package zuo.intermediate.class01;

/**
 * 给定一个函数f，可以1～5的数字等概率返回一个。请加工出1～7的数字等概率
 * 返回一个的函数g。
 * 给定一个函数f，可以a～b的数字等概率返回一个。请加工出c～d的数字等概率
 * 返回一个的函数g。
 * 给定一个函数f，以p概率返回0，以1-p概率返回1。请加工出等概率返回0和1的
 * 函数g
 */
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
