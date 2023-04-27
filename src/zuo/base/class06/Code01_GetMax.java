package zuo.base.class06;

/**
 * 请确保参数N，不是1就是0的情况下
 * 1-->0
 * 0-->1
 */
public class Code01_GetMax {
    public static int flip(int n) {
        return n ^ 1;
    }

    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return scA * a + scB * b;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
