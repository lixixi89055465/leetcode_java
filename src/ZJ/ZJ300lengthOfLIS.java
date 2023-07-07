package ZJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZJ300lengthOfLIS {
    private static class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> dp = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (dp.isEmpty() || nums[i] > dp.get(dp.size() - 1)) {
                    dp.add(nums[i]);
                    continue;
                }
                int left = 0, right = dp.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) == nums[i]) {
                        right=mid;
                        break;
                    } else if (dp.get(mid) > nums[i]) {
                        right = mid;
                    } else {
                        left += 1;
                    }
                }
                dp.set(right, nums[i]);
            }
            return dp.size();
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = new int[]{0,1,0,3,2,3};
//        int[] nums = new int[]{7,7,7,7,7,7,7};
        int[] nums = new int[]{4,10,4,3,8,9};
        System.out.println(solve.lengthOfLIS(nums));

    }
}
