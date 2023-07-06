package leetcode.a000;

public class H53maxSubArray {
    private static class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            int pre = nums[0];
            int ans = pre;
            for (int i = 1; i < length; i++) {
                if (pre > 0) {
                    pre = pre + nums[i];
                } else {
                    pre = nums[i];
                }
                ans = Math.max(ans, pre);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = new int[]{5, 4, -1, 7, 8};
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }
}
