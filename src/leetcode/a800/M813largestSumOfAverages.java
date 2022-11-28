package leetcode.a800;

import java.util.PriorityQueue;

/**
 * 813. 最大平均值和的分组
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
 * <p>
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * <p>
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [9,1,2,3,9], k = 3
 * 输出: 20.00000
 * 解释:
 * nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 nums 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 4
 * 输出: 20.50000
 */
public class M813largestSumOfAverages {
    protected static class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            double[][] dp = new double[k + 1][nums.length + 1];
            double s = 0;
            for (int i = 1; i <= nums.length; i++) {
                s += nums[i - 1];
                dp[1][i] = s / i;
            }

            for (int i = 2; i <= k; i++) {
                for (int j = i; j <= nums.length; j++) {
                    s = 0;
                    dp[i][j] = dp[i - 1][j - 1] + nums[j - 1];
                    for (int L = 0; L <= j - i; L++) {
                        s += nums[j - L - 1];
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - L - 1] + s / (L + 1));
                    }
                }
            }
            return dp[k][nums.length];
        }
    }

    public static void main(String[] args) {

        int[] nums = {9, 1, 2, 3, 9};
        int k = 3;
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 4;
//        int[] nums = {4, 1, 7, 5, 6, 2, 3};
//        int k = 4;
//        int[] nums = {1};
//        int k = 1;
        Solution solution = new Solution();
        double result = solution.largestSumOfAverages(nums, k);
        System.out.println(result);
    }
}
