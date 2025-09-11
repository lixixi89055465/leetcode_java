package leetcode.a300;

import java.util.ArrayList;

public class M300lengthOfLIS {
    private static class Solution {
        public int lengthOfLIS(int[] nums) {
            ArrayList<Integer> dp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (dp.isEmpty() || nums[i] > dp.get(dp.size() - 1)) {
                    dp.add(nums[i]);
                    continue;
                }
                int left = 0, right = dp.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) == nums[i]) {
                        right = mid;
                        break;
                    } else if (dp.get(mid) > nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                dp.set(right, nums[i]);
            }
            return dp.size();
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution ss = new Solution();
        int i = ss.lengthOfLIS(nums);
        System.out.println(i);
    }
}
