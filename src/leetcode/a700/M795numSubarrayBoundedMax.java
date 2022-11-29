package a700;

import java.util.Stack;

public class M795numSubarrayBoundedMax {
    protected static class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            return count(nums, right) - count(nums, left - 1);
        }

        private int count(int[] nums, int lower) {
            int res = 0, cur = 0;
            for (int num : nums) {
                cur = num <= lower ? cur + 1 : 0;
                res += cur;
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 4, 3};
//        int left = 2, right = 3;
//        int []nums = {2,9,2,5,6};
//        int left = 2, right = 8;
        int[] nums = {73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
        int left = 32, right = 69;
//        int[] nums = {34, 46, 51, 92, 50, 61, 49, 82, 4, 4};
//        int left = 18, right = 84;
        Solution solution = new Solution();
        int result = solution.numSubarrayBoundedMax(nums, left, right);
        System.out.println(result);
    }
}
