package leetcode.a1400;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class M1438longestSubarray {
    private static class Solution {

        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> minDeque = new LinkedList<>();
            Deque<Integer> maxDeque = new LinkedList<>();

            int res = 0;
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[i]) {
                    maxDeque.pollLast();
                }
                while (!minDeque.isEmpty() && minDeque.peekLast() > nums[i]) {
                    minDeque.pollLast();
                }

                minDeque.offerLast(nums[i]);
                maxDeque.offerLast(nums[i]);
                while (!minDeque.isEmpty() && !maxDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                    if (minDeque.peekFirst() == nums[start]) {
                        minDeque.pollFirst();
                    }
                    if (maxDeque.peekFirst() == nums[start]) {
                        maxDeque.pollFirst();
                    }
                    start++;
                }
                res = Math.max(res, i - start + 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10, 1, 2, 4, 7, 2};
        int limit = 5;
        System.out.println(solution.longestSubarray(nums, limit));
    }
}
