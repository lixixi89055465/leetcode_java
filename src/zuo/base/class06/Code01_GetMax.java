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
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb; //a和b的符号不一样
        int sameSab = flip(difSab);// a和b的符号一样，为1；不一样，为0
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main1(String[] args) {
        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
    }

    public static void main(String[] args) {
//        int a = 16;
        int a = 32;
        int b = a & (a - 1);
        System.out.println(b);
        a = a>>2;
        b = a & (a - 1);
        System.out.println(b);
    }
}
