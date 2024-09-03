package zuo.intermediate.class02;

/**
 * 动物吃草问题
 */
public class Problem05_Eat {
    public static String winner1(int n) {
        int base = 1;
        if (n < 5) {
            return n == 2 || n == 0 ? "后手" : "先手";
        }
        while (base <= n) {
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) {
                break;
            }
            base *= 4;
        }
        return "后手";

    }

    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(i + " : " + winner1(i));
        }
    }
}
