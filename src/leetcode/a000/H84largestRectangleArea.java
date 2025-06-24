package leetcode.a000;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class H84largestRectangleArea {
    private static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[heights.length];
            left[0] = -1;
            stack.push(-1);
            for (int i = 0; i < heights.length; i++) {
                while (stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left[i] = stack.peek();
                stack.push(i);
            }
//            RandomUtils.printArray(left);
            int[] right = new int[heights.length];
            stack.clear();
            stack.push(heights.length);
            for (int i = heights.length - 1; i >= 0; i--) {
                while (stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right[i] = stack.peek();
                stack.push(i);
            }
//            RandomUtils.printArray(right);
            int res = 0;
            for (int i = 0; i < heights.length; i++) {
                res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};
        int[] heights = {2, 4};
        int res = s.largestRectangleArea(heights);
        System.out.println(res);
    }
}
