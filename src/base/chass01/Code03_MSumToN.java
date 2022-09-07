package base.chass01;

public class Code03_MSumToN {
    public static boolean isSum1(int n) {
        for (int i = 1; i < n; i++) {
            int sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;
                if (sum == n) {
                    return true;
                }
                if (sum > n) {
                    break;
                }
            }
        }
        return false;
    }

    public static boolean isSum2(int n) {
        if (n < 3) {
            return false;
        }
        return (n & (n - 1)) != 0;

    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + ":" + isSum1(i));

        }
    }
}
