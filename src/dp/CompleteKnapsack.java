package dp;

public class CompleteKnapsack {


    public static int CKnapsack1(int[] w, int[] v, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    for (int k = 1; k <= j / w[i - 1]; k++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * w[i - 1]] + k * v[i - 1]);
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static int CKnapsack2(int[] w, int[] v, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] w = {3, 1, 2, 2};         // 物品的重量
        int[] v = {20, 10, 10, 15};     // 物品的价值
        int n = w.length;               // 物品的个数
        int m = 5;                      // 背包的容量
        int result = CKnapsack2(w, v, n, m);
        System.out.println(result);

    }
}
