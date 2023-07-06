package leetcode.a200;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

public class M215_findKthLargest {
    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minStack = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                if (minStack.size() < k) {
                    minStack.add(nums[i]);
                } else if (nums[i] > minStack.peek()) {
                    minStack.poll();
                    minStack.add(nums[i]);
                }
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        int k = 2;
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = solution.findKthLargest(nums, k);
        System.out.println(res);
    }
}
