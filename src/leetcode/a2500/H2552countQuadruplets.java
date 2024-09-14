package leetcode.a2500;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/12 14:00
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 2552. 统计上升四元组
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。
 * <p>
 * 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的：
 * <p>
 * 0 <= i < j < k < l < n 且
 * nums[i] < nums[k] < nums[j] < nums[l] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,4,5]
 * 输出：2
 * 解释：
 * - 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
 * - 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
 * 没有其他的四元组，所以我们返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 4 <= nums.length <= 4000
 * 1 <= nums[i] <= nums.length
 * nums 中所有数字 互不相同 ，nums 是一个排列。
 */
public class H2552countQuadruplets {
    private static class Solution {
        public long countQuadruplets(int[] nums) {
            int n = nums.length + 1;
            int[][] dpXiao = new int[n][n];
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    dpXiao[i][j] = dpXiao[i + 1][j];
                    for (int k = 0; k < j - i; k++) {
                        if (nums[i] > nums[j - k]) {
                            dpXiao[i][j] += 1;
                        }
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 3; j < n; j++) {
                    res += dpXiao[i + 1][j - 1];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}