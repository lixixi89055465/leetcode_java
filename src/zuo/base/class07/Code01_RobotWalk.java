package zuo.base.class07;

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

    public static int walkWay2(int N, int E, int S, int K) {
        int[][] dp = new int[S + 1][K + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }

        return f2(dp, N, E, S, K);
    }

    private static int f2(int[][] dp, int N, int E, int S, int K) {
        if (dp[S][K] != -1) {
            return dp[S][K];
        }
        if (S == 0) {
            if (K == E) {
                dp[K][S] = 0;
                return 1;
            } else {
                return 0;
            }
        }
        if (K == 1) {
            dp[S][K] = 1 + f2(dp, N, E, S - 1, 2);
        }
        if (K == N) {
            dp[S][K] = 1 + f2(dp, N, E, S - 1, N - 1);
        }
        dp[S][K] = 1 + Math.min(f2(dp, N, E, S - 1, K - 1), f2(dp, N, E, S - 1, K + 1));
        return dp[S][K];
    }
}
