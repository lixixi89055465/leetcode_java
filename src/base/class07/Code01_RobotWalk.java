package base.class07;

import java.util.Stack;

/**
 * 递归机器人
 */
public class Code01_RobotWalk {
    public static int walkWays(int N, int P, int M, int K) {
        return f(N, P, K, M);
    }

    private static int f(int N, int E, int rest, int cur) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            return f(N, E, rest - 1, 2);
        }
        if (cur == N) {
            return f(N, E, rest - 1, N - 1);
        }
        return f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
    }


    public static int walkWays2(int N, int E, int S, int K) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(N, E, K, S, dp);
    }

    private static int f2(int N, int E, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1) {
            dp[rest][cur] = f(N, E, rest - 1, 2);
            return dp[rest][cur];
        }
        if (cur == N) {
            dp[rest][cur] = f(N, E, rest - 1, N - 1);
            return dp[rest][cur];
        }
        dp[rest][cur] = f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
        return dp[rest][cur];
    }
}
