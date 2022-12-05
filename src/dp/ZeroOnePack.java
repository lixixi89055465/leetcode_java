package dp;

public class ZeroOnePack {
    public static int zeroOne(int N, int M, int[] w, int[] v) {
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; i++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
                }
            }
        }
        return dp[N][M];
    }

    public static void main(String[] args) {

    }
}
