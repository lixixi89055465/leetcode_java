package zuo.intermediate.class08;

public class Problem05 {

    public static int minCost1(String str1, String str2, int dc, int ic, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length;
        int col = chs2.length;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; i++) {
                if (chs1[row] == chs2[col]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }
}
