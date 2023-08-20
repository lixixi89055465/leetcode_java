package leetcode.a1300;

/**
 * 1388. 3n 块披萨
 * 提示
 * 困难  1,2,3,4,5,6,7,8,9
 * 176
 * 相关企业
 * 给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
 * 你挑选 任意 一块披萨。
 * Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
 * Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
 * 重复上述过程直到没有披萨剩下。
 * 每一块披萨的大小按顺时针方向由循环数组 slices 表示。
 * 请你返回你可以获得的披萨大小总和的最大值。
 * 示例 1：
 * 输入：slices = [1,2,3,4,5,6]
 * 输出：10
 * 解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
 * 示例 2：
 * 输入：slices = [8,9,8,6,1,1]
 * 输出：16
 * 解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
 * 1 <= slices.length <= 500
 * slices.length % 3 == 0
 * 1 <= slices[i] <= 1000
 * * 输入：slices = [1,2,3,4,5,6,7,8,9]
 * 通过次数
 * 11.8K
 * 提交次数
 * 18.9K
 * 通过率
 * 62.2%
 */
public class H1388maxSizeSlices {
    private static class Solution {
        public int maxSizeSlices(int[] slices) {
            int[] v1 = new int[slices.length - 1];
            int[] v2 = new int[slices.length - 1];
            System.arraycopy(slices, 0, v1, 0, slices.length - 1);
            System.arraycopy(slices, 1, v2, 0, slices.length - 1);
            int res1 = calculate(v1);
            int res2 = calculate(v2);
            return Math.max(res1, res2);
        }
        private int calculate(int[] slices) {
            int n = slices.length;
            int[][] dp = new int[n + 1][(n + 1) / 3 + 1];
            dp[1][1] = slices[0];
            dp[2][1] = Math.max(slices[0], slices[1]);
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= (i + 1) / 2 && j <= (n + 1) / 3; j++) {
                    dp[i][j] = Math.max(slices[i - 1] + dp[i - 2][j - 1], dp[i - 1][j]);
                }
            }
            return dp[n][(n + 1) / 3 ];
        }
    }



    public static void main(String[] args) {
//        int[] slices = {1, 2, 3, 4, 5, 6};
//        int[] slices = {1, 2, 3};
//        int[] slices = {8, 9, 8, 6, 1, 1};
        int[] slices = {9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7};
        Solution solve = new Solution();
        System.out.println(solve.maxSizeSlices(slices));
    }
}
