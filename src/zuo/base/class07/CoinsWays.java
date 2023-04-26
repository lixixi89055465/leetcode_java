package zuo.base.class07;

public class CoinsWays {
    //arr里都是正数，没有重复值，每个值代表一种货币，每一种都可以用无限次
    //最终要找零钱数是aim,
    //找零方法数返回
    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (index == 0) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }

    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0]=0;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
                    ways += dp[index + 1][rest - arr[index] * zhang];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        int ways = 0;
        for (int i = 0; i * arr[index] <= rest; i++) {
            ways += process2(arr, index + 1, rest - arr[index] * i, dp);
        }
        dp[index][rest] = ways;
        return ways;
    }
}
