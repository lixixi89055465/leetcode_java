package zuo.intermediate.class08;

public class Problem05_EditCost {

    public static int minCost1(String str1, String str2, int dc, int ic, int rc) {
        if (str1 == null || str2 == null||str1.length()==0||str2.length()==0) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length +1;
        int col = chs2.length +1;
        int[][] dp = new int[row][col];
        for (int i = 0; i <row; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i <row; i++) {
            for (int j = 1; j <col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }

    public static  int minOperationCount(String source, String target) {
        // write code here
        int result = minCost1(source, target, 1, 1, 1);
        return result;

    }

    public static void main(String[] args) {
        System.out.println(minOperationCount("abc", "de"));
    }
}
