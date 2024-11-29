package leetcode.a2500;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/26 22:25
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class S2535differenceOfSum {
    private static class Solution {
        public int differenceOfSum(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int tmp = nums[i];
                res += nums[i];
                while (tmp > 0) {
                    res -= (tmp % 10);
                    tmp /= 10;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 15, 6, 3};
        int[] nums = {1,2,3,4};
        Solution s = new Solution();
        int res = s.differenceOfSum(nums);
        System.out.println(res);
    }
}
