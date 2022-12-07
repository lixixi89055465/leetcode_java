package dp;

import java.util.Arrays;

public class ZeroOnePack {
    public static int zeroOne(int N, int M, int[] w, int[] v) {
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
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
            for (int j = M; j >= 0; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }

        }
        return dp[M];
    }

    public static int zeroOne2(int N, int M, int[] w, int[] v) {
        int[] dp = new int[M + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = M; j > 0; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        if (dp[M] < 0) dp[M] = 0;
        return dp[M];
    }

    public static int zeroOne3(int N, int M, int[] w, int[] v) {
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; i < M + 1; i++) {
                if (w[i - 1] > M) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int temp = Integer.MIN_VALUE;
                    for (int k = 1; k <= j / w[i - 1]; k++) {
                        temp = Math.max(temp, dp[i - 1][j - k * w[i - 1]] + k * v[i - 1]);
                    }
                    dp[i][j] = Math.max(temp, dp[i - 1][j]);
                }
            }
        }
        return dp[N][M];
    }

    public static int zeroOne4(int N, int M, int[] w, int[] v) {
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; i++) {
                if (w[i - 1] > M) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[N][M];
    }

    public static int zeroOne5(int N, int M, int[] w, int[] v) {
        int[] dp = new int[M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; i < M + 1; i++) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }

        }
        return dp[M];
    }

    public static int zeroOne6(int N, int M, int[] w, int[] v) {
        int[] dp = new int[M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        if (dp[M] < 0) dp[M] = 0;
        return dp[M];

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
