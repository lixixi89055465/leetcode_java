package leetcode.a000;

import leetcode.a1400.M1423maxScore;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月25日 15:02
 * 项目名称: leetcode_java
 * 文件名称: M62
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright:
 */

public class M62 {
    private static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 3, n = 7;
        int res = s.uniquePaths(m, n);
        System.out.println(res);
    }
}

