package base.chass01;

public class Code02_EatGrass {
    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        }
        return "先手";
    }

    public static String winner1(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        int base = 1;
        while (base < n) {
            if (winner1(n - base) == "后手") {
                return "先手";
            }
            if (base > n / 4) {//防止 base*4 溢出
                break;
            }
            base *= 4;
        }
        return "后手";
    }
}
