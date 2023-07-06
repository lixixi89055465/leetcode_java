package leetcode.a1000;

/**
 * 1004. 最大连续1的个数 III
 */
public class M1004longestOnes {
    private static class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0, right = 0;
            int n = nums.length;
            int zeroNum = 0;
            int res = 0;
            while ( right < n) {
                if (nums[right] == 1 || zeroNum < k) {
                    zeroNum += nums[right] == 1 ? 0 : 1;
                    right++;
                } else {
                    zeroNum += nums[left] == 1 ? 0 : -1;
                    left++;
                }
                res = Math.max(res, right - left);
            }
            return  res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        int K = 3;
//        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        int K = 2;
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 0;
//        int[] nums = new int[]{0, 0, 1, 1, 1, 0, 0};
//        int K = 0;
        int res = solution.longestOnes(nums, K);
        System.out.println(res);
    }
}
