package zuo.base.class12;

public class Code03_Knapsack {
    public static int getMaxValue(int[] w, int[] v, int bag) {
        int[][] dp = new int[v.length + 1][bag + 1];
        for (int i = 0; i < v.length + 1; i++) {
            for (int j = 0; j < bag + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process(w, v, 0, bag, dp);

    }

    private static int process(int[] w, int[] v, int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            dp[index][rest] = 0;
            return 0;
        }
        if (dp[index][rest] > 0) {
            return dp[index][rest];
        }
        dp[index + 1][rest] = process(w, v, index + 1, rest, dp);
        dp[index][rest] = dp[index + 1][rest];
        if (rest >= w[index]) {
            dp[index + 1][rest - w[index]] = process(w, v, index + 1, rest - w[index], dp);
            dp[index][rest] = Math.max(dp[index][rest], dp[index + 1][rest - w[index]] + v[index]);
        }
        return dp[index][rest];
    }

    public static int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest >= w[index]) {
                    dp[index][rest] = Math.max(dp[index][rest], dp[index + 1][rest - w[index]] + v[index]);
                }
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(getMaxValue(weights, values, bag));
        System.out.println(dpWay(weights, values, bag));
    }

}
