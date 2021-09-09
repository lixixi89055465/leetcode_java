package dp;

/**
 * 基本动态规划之硬币问题
 *
 * 问题描述
 * 假设有 1 元，3 元，5 元的硬币若干（无限），现在需要凑出 11 元，问如何组合才能使硬币的数量最少？
 */
public class CoinProblemBasicTest {


    public static void main(String[] args) {
        int n = 100;
        int[] dp = new int[100]; // 储存结果
        int[] coins = {1, 3, 5}; // 硬币种类
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println(dp[i]);
        }
        System.out.println(dp[99]);
        System.out.println("aaaaaaaa");

    }
}
