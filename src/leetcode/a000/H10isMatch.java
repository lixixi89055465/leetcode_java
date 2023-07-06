package leetcode.a000;


import zuo.publicclass2020.class094.Code03_RightView;

public class H10isMatch {
    private static class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
                return false;
            }
            int slen = s.length();
            int plen = p.length();
            char[] schs = s.toCharArray();
            char[] pchs = p.toCharArray();
            boolean[][] dp = new boolean[plen + 1][slen + 1];
            if (pchs[plen - 1] == '*' && plen > 1) {
                dp[plen - 2][slen] = true;
            }
            dp[plen][slen] = true;
            for (int i = plen - 1; i >= 0; i--) {
                for (int j = slen; j >= 0; j--) {
                    if (j == slen) {
                        dp[i][j] = i + 1 < plen && pchs[i + 1] == '*' ? dp[i + 2][j] : false;
                    } else {
                        if (i + 1 < plen && pchs[i + 1] == '*') {
                            dp[i][j] = pchs[i] == '.' || pchs[i] == schs[j] ? dp[i][j + 1] || dp[i + 2][j] : dp[i + 2][j];
                        } else {
                            dp[i][j] = pchs[i] == '.' || pchs[i] == schs[j] ? dp[i + 1][j + 1] : false;
                        }
                    }
                }
            }
            return dp[0][0];
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "aa", p = "a";
//        String s = "aa", p = "a*";
        String s = "aabcbcbcaccbcaabc", p = ".*a*aa*.*b*.c*.*a*";

        System.out.println(solution.isMatch(s, p));

    }
}
