package zuo.senior.class04;

public class Code02_SplitNumber {
    public static Integer isSplit1(int num) {
        if (num <= 0) {
            return 0;
        }
        return process(1, num);
    }

    public static int process(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (pre > rest) {
            return 0;
        }
        int ways = 0;
        for (int i = pre; i <= rest; i++) {
            ways += process(i, rest - i);
        }
        return ways;
    }

    public static int ways2(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int pre = 1; pre < dp.length; pre++) {
            dp[pre][0] = 1;
        }
        for (int pre = n; pre > 0; pre--) {
            for (int rest = pre; rest <= n; rest++) {
                for (int i = pre; i <= rest; i++) {
                    dp[pre][rest] += dp[i][rest - i];

                }
            }

        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int num = 128; // 0...0111
//        printNumberBinary(num);
//        printNumberBinary(num - 1);

//		for (int i = 0; i < 100; i++) {
//			System.out.println(i + " : " + isSplit2(i));
//		}
    }

}
