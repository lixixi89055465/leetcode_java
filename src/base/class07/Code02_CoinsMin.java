package base.class07;

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
        int p2Next = process(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2Next == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2Next + 1;
            }
            if (p2Next == -1) {
                return p1;
            }
            return Math.min(p1, p2Next + 1);
        }
    }


    public static int minCoins2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            dp[index][rest] = 0;
            return dp[index][rest];
        }
        if (index == arr.length) {
            return -1;
        }
        int p1 = process(arr, index + 1, rest);
        dp[index + 1][rest] = p1;
        int p2Next = process(arr, index + 1, rest - arr[index]);
        dp[index + 1][rest - arr[index]] = p2Next;
        if (p1 == -1 && p2Next == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                dp[index][rest] = p2Next + 1;
                return p2Next + 1;
            }
            if (p2Next == -1) {
                dp[index][rest] = p1;
                return p1;
            }
            dp[index][rest] = Math.min(p1, p2Next + 1);
            return dp[index][rest];
        }
    }

    public static int[] generateRandomArray(int len, int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    public static int minCoins3(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int row = 0; row <= N; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2Next = -1;
                if (rest - arr[index] >= 0) {
                    p2Next = dp[index + 1][rest - arr[index]];
                }
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
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, max);
            int aim = (int) (Math.random() * 3 * max) + max;
            if (minCoins1(arr, aim) != minCoins2(arr, aim)) {
                System.out.println("oooops!");
                break;
            }
        }
    }
}
