package ZJ;

/**
 * 152. 乘积最大子数组
 * 中等
 * 2.1K
 * 相关企业
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数*
 */
public class ZJ152maxProduct {
    private static class Solution {
        public int maxProduct(int[] nums) {
            int res = nums[0];
            int maxV = nums[0];
            int minV = nums[0];
            int a = 0, b = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    a = Math.max(nums[i], maxV * nums[i]);
                    b = Math.min(nums[i], minV * nums[i]);
                    maxV = a;
                    minV = b;
                } else if (nums[i] < 0) {
                    a = Math.max(nums[i], minV * nums[i]);
                    b = Math.min(nums[i], maxV * nums[i]);
                    maxV = a;
                    minV = b;
                } else {
                    maxV = 0;
                    minV = 0;
                }
                res = Math.max(res, maxV);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-4, -3, -2};
        System.out.println(solve.maxProduct(nums));

    }
}

/**
 * 128. 最长连续序列
 * 中等
 * 1.7K
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */