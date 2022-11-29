package a1700;

public class S1752check {
    protected static class Solution {
        public boolean check(int[] nums) {
            int firstMinIndex = 0;
            int firstMaxIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    break;
                }
                firstMaxIndex = i;
            }
            for (int i = firstMaxIndex + 1; i < nums.length; i++) {
                if (i == nums.length - 1 && nums[i] <= nums[firstMinIndex]) {
                    return true;
                }
                if (nums[firstMinIndex] < nums[i] || nums[i] > nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {2, 1, 3, 4};
        int[] nums = {1,2,3};
        Solution solution = new Solution();

        boolean result = solution.check(nums);
        System.out.println(result);
    }
}
