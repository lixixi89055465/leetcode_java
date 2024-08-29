package zuo.intermediate.class08;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic、dc和rc，分别代表插入、删
 * 除和替换一个字符的代价，返回将str1编辑成str2的最小代价。
 * 【举例】
 * str1="abc"，str2="adc"，ic=5，dc=3，rc=2
 * 从"abc"编辑成"adc"，把'b'替换成'd'是代价最小的，所以返回2
 * str1="abc"，str2="adc"，ic=5，dc=3，rc=100
 * 从"abc"编辑成"adc"，先删除'b'，然后插入'd'是代价最小的，所以返回8
 * str1="abc"，str2="abc"，ic=5，dc=3，rc=2
 * 不用编辑了，本来就是一样的字符串，所以返回0
 */
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
