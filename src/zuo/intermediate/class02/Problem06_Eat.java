package zuo.intermediate.class02;

public class Problem06_Eat {
    public static String winner1(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "先手" : "后手";
        }
        int base = 1;
        while (base <= n) {
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            if (base * 4 > n) {
                break;
            }
            base *= 4;
        }
        return "后手";
    }
}
