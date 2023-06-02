package zuo.senior.class04;

public class Problem05_PalindromeWays {
    private static int minParts(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        char[] strs = s.toCharArray();
        dp[s.length() - 1] = 1;
        int start = s.length() - 2;
        for (int i = start; i >= 0; i--) {
            int cur = 0;
            for (int j = s.length() - 1; j > i; j--) {
                if (isPalindrome(strs, i, j - 1)) {
                    cur = Math.max(cur, dp[j] + 1);
                }
            }
            dp[i] = cur;
        }
        return dp[0];
    }

    private static boolean isPalindrome(char[] strs, int i, int j) {
        while (i < j) {
            if (strs[i++] != strs[j--]) {
                return false;
            }
        }
        return true;
    }

    private static int process(char[] str, int i) {

        return 0;
    }
}
