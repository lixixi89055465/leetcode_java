package dp;

public class ZeroOnePack {
    public static int zeroOne(int N, int M, int[] w, int[] v) {
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; i < M + 1; i++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[N][M];
    }

    public static int zeroOne1(int N, int M, int[] w, int[] v) {
        int[] dp = new int[M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = M; i >= 0; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[M];
    }

    public static int zeroOne2(int N, int M, int[] w, int[] v) {
        int[] dp = new int[M + 1];
        dp[0] = 0;
        for (int i = 1; i < M + 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = M; j >= 0; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], v[i - 1] + dp[j - w[i - 1]]);
                }
            }
        }
        return dp[M];
    }

    public static int zeroOne3(int N, int M, int[] w, int[] v) {
        int[][] dp = new int[N + 1][M + 1];
        int[][] path = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
                    path[i][j] = 1;
                }
            }
        }
        for (int i = N, j = M; i >= 0; i--) {
            if (path[i][j] == 1) {
                System.out.println("走了" + i + "," + j);
                j -= w[i - 1];
            }
        }
        return dp[N][M];
    }

    public static void main(String[] args) {
//        int[] w = {2, 1, 3, 2};         // 物品的重量
//        int[] v = {10, 10, 20, 15};     // 物品的价值
//        int n = w.length;               // 物品的个数
//        int m = 5;                      // 背包的容量
//        int result = zeroOne3(n, m, w, v);
//        System.out.println(result);
        // 示例2
        int[] w = {3, 1, 2, 2};         // 物品的重量
        int[] v = {20, 10, 10, 15};     // 物品的价值
        int n = w.length;               // 物品的个数
        int m = 5;                      // 背包的容量
        int result = zeroOne2(n, m, w, v);
        System.out.println(result);

    }

}
