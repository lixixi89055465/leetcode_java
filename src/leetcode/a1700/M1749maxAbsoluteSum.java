package leetcode.a1700;

/**
 * 1749. 任意子数组和的绝对值的最大值
 * 提示
 * 中等
 * 140
 * 相关企业
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * abs(x) 定义如下：
 * <p>
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class M1749maxAbsoluteSum {
    private static class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int pre = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (pre + nums[i] < 0) {
                    pre = 0;
                } else {
                    pre = pre + nums[i];
                }
                res = Math.max(res, pre);
            }
            int res1=0;
            pre=0;
            for (int i = 0; i < nums.length; i++) {
                int a=-nums[i];
                if (pre + a < 0) {
                    pre = 0;
                } else {
                    pre = pre + a;
                }
                res = Math.max(res, pre);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};
        Solution solve = new Solution();
        System.out.println(solve.maxAbsoluteSum(nums));
    }
}
