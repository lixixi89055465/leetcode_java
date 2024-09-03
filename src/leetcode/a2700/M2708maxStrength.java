package leetcode.a2700;

import java.util.PriorityQueue;

public class M2708maxStrength {
    static class Solution {
        public long maxStrength(int[] nums) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            long res = 1;
            int zheng = 0;
            int zero = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    zheng++;
                    res *= nums[i];
                } else if (nums[i] < 0) {
                    queue.add(nums[i]);
                } else {
                    zero++;
                }
            }
            if (zheng == 0 && queue.size() <= 1) {
                return zero > 0 ? 0 : queue.poll();
            }
            if ((queue.size() & 1) != 0) {
                queue.poll();
            }
            while (!queue.isEmpty()) {
                res *= queue.poll();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = {3, -1, -5, 2, 5, -9};
//        int[] nums = {0, -1};
        int []nums= {6,-3,-4,8,4,7,6,4,7,7,-3,-6,9};
        System.out.println(solve.maxStrength(nums));

    }
}
