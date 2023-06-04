package zuo.senior.class05;

public class Problem02_SplitNumer {
    private static int process(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (pre > rest) {
            return 0;
        }
        int res = 0;
        for (int i = pre; i <= rest; i++) {
            res += process(i, rest - i);
        }
        return res;
    }

    private static int process2(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
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

    private static int process3(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int pre = n; pre > 0; pre--) {
            for (int rest = pre; rest <= n; rest++) {
                dp[pre][rest] += dp[pre][rest - pre] + dp[pre + 1][rest];
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int result = process(1, 4);
        System.out.println(result);
    }
}
