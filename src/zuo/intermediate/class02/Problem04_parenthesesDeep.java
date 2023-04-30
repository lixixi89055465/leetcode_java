package zuo.intermediate.class02;

public class Problem04_parenthesesDeep {
    public static int maxLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] strs = s.toCharArray();
        int pre = 0;
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && strs[pre] == '(') {
                    dp[i] = strs[pre] == strs[i] ? (dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0)) : 0;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

