package a800;

/**
 * 878. 第 N 个神奇数字
 * 一个正整数如果能被 HJ93 或 b 整除，那么它是神奇的。
 * <p>
 * 给定三个整数 n , HJ93 , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, HJ93 = 2, b = 3
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 4, HJ93 = 2, b = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 2 <= HJ93, b <= 4 * 104
 */
public class H878nthMagicalNumberhard {
    public static int nthMagicalNumber(int n1, int a, int b) {
        long n = n1;
        long commonMultiple = a * b / getCommonDivisor(a, b);
        long nei = (commonMultiple / a) + (commonMultiple / b) - 1;
        long ans = (n / nei) * commonMultiple;
        n = n % nei;
        ans += getAB(n, a, b);
        return (int) (ans % 1000000007);
    }

    private static int getAB(long n, int a, int b) {
        int ai = 0;
        int bi = 0;
        for (int i = 0; i < n; i++) {
            if (ai + a > bi + b) {
                bi += b;
            } else {
                ai += a;
            }
        }
        return Math.max(ai, bi);
    }

    private static int getCommonDivisor(int ai, int bi) {
        int a = ai > bi ? ai : bi;
        int b = ai > bi ? bi : ai;
        int c = 0;
        while (a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
//        System.out.println(nthMagicalNumber(1, 2, 3));
//        System.out.println(nthMagicalNumber(4, 2, 3));
        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));
    }
}
