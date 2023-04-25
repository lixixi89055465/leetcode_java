package zuo.base.class06;

/**
 * 请确保参数N，不是1就是0的情况下
 * 1-->0
 * 0-->1
 */
public class Code02_Power {
    public static boolean is2Power(int n) {
        return (n & (n - 1)) == 0;
    }

    public static boolean is4Power(int n) {
        return is2Power(n) && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        int n = 16;
        int a = n - 1;
        int b = n & a;
        System.out.println(b);
    }
}
