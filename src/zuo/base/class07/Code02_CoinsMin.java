package zuo.base.class07;


/**
 * 递归机器人
 */
public class Code02_CoinsMin {

    public static int minCoins1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int p1 = process(arr, index + 1, rest);
        int p2next = process(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2next == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2next + 1;
            } else {
                return p1;
            }
        }
    }

    public static int minCoin2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (rest < 0) {
            dp[index][rest] = -1;
            return -1;
        }
        if (rest == 0) {
            dp[index][rest] = 0;
            return 0;
        }
        if (index == arr.length) {
            dp[index][rest] = -1;
            return -1;
        }
        int p1 = process2(arr, index + 1, rest, dp);
        int p2Next = process2(arr, index + 1, rest - arr[index], dp);
        if (p1 == -1 && p2Next == -1) {
            dp[index][rest] = -1;
        } else {
            if (p1 == -1) {
                dp[index][rest] = p2Next + 1;
            } else if (p2Next == -1) {
                dp[index][rest] = p1;
            } else {
                dp[index][rest] = Math.min(p1, p2Next + 1);
            }
        }
        return dp[index][rest];
    }
}

