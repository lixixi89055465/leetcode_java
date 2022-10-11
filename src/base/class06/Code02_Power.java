package base.class06;

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
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
