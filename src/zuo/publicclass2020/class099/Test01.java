package zuo.publicclass2020.class099;


public class Test01 {
    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if ((sum & 3) != 0) {
            return false;
        }
        int[] dp = new int[1 << matchsticks.length];
        return f(matchsticks, sum >> 2, 0, 0, 4, dp);
    }

    private static boolean f(int[] matchsticks, int len, int status, int cur, int edges, int[] dp) {
        if (dp[status] != 0) {
            return dp[status] == 1;
        }

        boolean ans = false;
        if (edges == 0) {
            ans = (status == (1 << matchsticks.length) - 1) ? true : false;
        } else {
            for (int i = 0; i < matchsticks.length; i++) {
                if ((status & (1 << i)) == 0) {
                    if ((cur + matchsticks[i]) < len) {
                        ans |= f(matchsticks, len, status | (1 << i), cur + matchsticks[i], edges, dp);
                    } else if (cur + matchsticks[i] > len) {
                        continue;
                    } else {
                        ans |= f(matchsticks, len, status | (1 << i), 0, edges - 1, dp);
                    }
                    if (ans) {
                        break;
                    }
                }
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }
}
