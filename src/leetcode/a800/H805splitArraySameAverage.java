package leetcode.a800;

import java.util.HashSet;
import java.util.Set;

public class H805splitArraySameAverage {
    protected static class Solution0 {
        public boolean splitArraySameAverage(int[] nums) {
            if (nums == null || nums.length < 2) {
                return false;
            }
            //nums,index,sum
            double sum1 = 0, sum2 = 0;
            int n1 = 0, n2 = 0;
            return process(nums, 0, sum1, n1, sum2, n2);
        }

        private boolean process(int[] nums, int index, double sum1, int n1, double sum2, int n2) {
            if (index == nums.length) {
                if (n1 != 0 && n2 != 0 && sum1 * n2 == sum2 * n1) {
                    return true;
                }
                return false;
            }
            boolean p1 = process(nums, index + 1, sum1 + nums[index], n1+1, sum2, n2);
            boolean p2 = process(nums, index + 1, sum1, n1 , sum2 + nums[index], n2 + 1);
            return p1 || p2;
        }
    }

    protected static class Solution1 {
        public boolean splitArraySameAverage(int[] nums) {
            if (nums == null || nums.length < 2) {
                return false;
            }
            int sum = 0;
            int n = nums.length;
            int m = nums.length / 2;
            for (int num : nums) {
                sum += num;
            }
            Set<Integer>[] dp = new Set[m + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new HashSet<Integer>();
            }
            dp[0].add(0);
            for (int num : nums) {
                for (int i = m; i >= 1; i--) {
                    for (int x : dp[i - 1]) {
                        int curr = x + num;
                        if (curr * n == sum * i) {
                            return true;
                        }
                        dp[i].add(curr);
                    }
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Solution0 solution = new Solution0();
//        int []nums = {1,2,3,4,5,6,7,8};
//        int[] nums = {3, 1};
        int[] nums = {6,8,18,3,1};
        boolean result = solution.splitArraySameAverage(nums);
        System.out.println(result);
    }
}
