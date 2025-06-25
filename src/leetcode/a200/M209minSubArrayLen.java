package leetcode.a200;

public class M209minSubArrayLen {
    private static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int sum = 0;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                while (sum >= target) {
                    res = Math.min(res, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            if(res==Integer.MAX_VALUE){
                return 0;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int target = 7;
//        int[] nums = {2, 3, 1, 2, 4, 3};
//        int target = 11;
//        int []nums = {1,1,1,1,1,1,1,1};
        int target = 4;
        int[] nums = {1, 4, 4};
        int res = s.minSubArrayLen(target, nums);
        System.out.println(res);

    }
}
