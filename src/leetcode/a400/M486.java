package leetcode.a400;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月25日 21:15
 * 项目名称: leetcode_java
 * 文件名称: M486
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright:
 */
public class M486 {
    private static class Solution {
        public boolean predictTheWinner(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int first = predictA(nums, 0, nums.length - 1);
            int second = sum - first;
            return first >= second;
        }

        private int predictA(int[] nums, int l, int r) {
            if (l == r) {
                return nums[l];
            }
            int p1 = predictB(nums, l + 1, r);
            int p2 = predictB(nums, l, r - 1);
            return Math.max(p1 + nums[l], p2 + nums[r]);
        }

        private int predictB(int[] nums, int l, int r) {
            if (l == r) {
                return 0;
            }
            int p1 = predictA(nums, l + 1, r);
            int p2 = predictA(nums, l, r - 1);
            return Math.min(p1, p2);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        Solution s = new Solution();
        s.predictTheWinner(nums);

    }
}
