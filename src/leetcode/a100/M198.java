package leetcode.a100;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月25日 22:39
 * 项目名称: leetcode_java
 * 文件名称: M198
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 * 198. 打家劫舍
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @Copyright:
 */
public class M198 {
    private static class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length + 1];
            dp[1] = nums[0];
            for (int i = 2; i <= length; i++) {
                int num = nums[i-1];
                dp[i] = Math.max(dp[i - 2] + num, dp[i - 1]);
            }
            return dp[length];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 7, 9, 3, 1};
        int res = s.rob(nums);
        System.out.println(res);
    }
}
