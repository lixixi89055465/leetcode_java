package ZJ;

import java.util.*;

public class ZJ128longestConsecutive {
    private static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            int res=1;
            for (int num : nums) {
                if (set.contains(num - 1)) {
                    continue;
                }
                int start=1;
                while (set.contains(num+start)){
                    start++;
                }
                res=Math.max(res,start);
            }
            return res ;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = solve.longestConsecutive(nums);
        System.out.println(res);
    }
}
