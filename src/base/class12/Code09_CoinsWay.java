package base.class12;

public class Code09_CoinsWay {
    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    public static int waysdp(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        int count = 0;
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = aim; rest >= 0; rest--) {
                if (index == arr.length - 1) {
                    dp[index][rest] = rest % arr[index] == 0 ? 1 : 0;
                    continue;
                }
                count = 0;
                while (rest - count >= 0) {
                    dp[index][rest] += dp[index + 1][rest - count];
                    count += arr[index];
                }
            }
        }
        return dp[0][aim];
    }

    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int count = 0;
        int ans = 0;
        while (count <= rest) {
            ans += process(arr, index + 1, rest - count);
            count += arr[index];
        }
        return ans;
    }

    private static int process1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int count = 0;
        int ans = 0;
        while (count <= rest) {
            ans += process1(arr, index + 1, rest - count);
            count += arr[index];
        }
        return ans;
    }

    public static int ways3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[arr.length+1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest]=ways;
            }
        }
        return dp[0][aim];
    }

    public static int ways4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[arr.length+1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= 0; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }

            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 50, 100};
        int sum = 1000;
        System.out.println(ways(arr, sum));
        System.out.println(waysdp(arr, sum));
        System.out.println(ways3(arr, sum));
        System.out.println(ways4(arr, sum));
    }

}
