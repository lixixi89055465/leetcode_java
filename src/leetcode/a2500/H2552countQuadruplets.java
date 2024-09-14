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
        public long countQuadruplets1(int[] nums) {
            long res = 0;
            int n = nums.length;
            long[] cnt3 = new long[n];
            for (int l = 0; l < n; l++) {
                int cnt2 = 0;
                for (int j = 0; j < l; j++) {
                    if (nums[j] < nums[l]) {
                        res += cnt3[j];
                        cnt2++;
                    } else {
                        cnt3[j] += cnt2;
                    }
                }
            }
            return res;

        }

        public long countQuadruplets(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            long ans = 0;
            for (int j = 0; j < n; j++) {
                int suf = 0;
                for (int k = n - 1; k > j; k--) {
                    if (nums[j] > nums[k]) {
                        ans += (long) pre[nums[k]] * suf;
                    } else {
                        ++suf;
                    }
                }
                for (int x = nums[j] + 1; x <= n; x++) {
                    ++pre[x];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 3, 2, 4, 5};
//        int []nums = {1,2,3,4};
        int[] nums = {2, 5, 3, 1, 4};
        long res = solution.countQuadruplets(nums);
        System.out.println(res);
    }
}
