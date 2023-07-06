package leetcode.a1100;

public class M1143longestCommonSubsequence {
    private static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            char[] chs1 = text1.toCharArray();
            char[] chs2 = text2.toCharArray();
            int[][] dp = new int[len1 + 1][len2 + 1];
            int res = 0;
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    dp[i][j] = chs1[i - 1] == chs2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        String text1 = "abcde", text2 = "ace";
//        String text1 = "abcde", text2 = "ace";
        String text1 = "ezupkr", text2 = "ubmrapg";
        Solution solution = new Solution();
        int res = solution.longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
}
