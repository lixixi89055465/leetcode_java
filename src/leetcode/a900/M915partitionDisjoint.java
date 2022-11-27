package leetcode.a900;

public class M915partitionDisjoint {

    public static class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int leftMax = nums[0];
            int leftPos = 0;
            int curMax = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                curMax = Math.max(nums[i], curMax);
                if (nums[i] < leftMax) {
                    leftMax = curMax;
                    leftPos = i;
                }
            }
            return leftPos + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 0, 6, 12};
//        int[] nums = {5, 0, 3, 8, 6, 9};
        int result = solution.partitionDisjoint(nums);
        System.out.println(result);
    }
}
