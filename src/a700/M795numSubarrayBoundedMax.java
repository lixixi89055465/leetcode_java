package a700;

import java.util.Stack;

public class M795numSubarrayBoundedMax {
    protected static class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int ans = 0;
            Stack<Integer> st = new Stack<Integer>();
            st.add(-1);
            int[] lefti = new int[nums.length];
            int[] righti = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                lefti[i] = 1;
                while (st.peek() != -1) {
                    if (nums[st.peek()] > nums[i]) {
                        break;
                    }
                    st.pop();
                }
                lefti[i] = i - st.peek();
                st.add(i);
            }
            st.clear();
            st.add(nums.length);
            for (int i = nums.length - 1; i >= 0; i--) {
                righti[i] = 1;
                while (st.peek() != nums.length) {
                    if (nums[st.peek()] >= nums[i]) {
                        break;
                    }
                    st.pop();
                }
                righti[i] = st.peek() - i;
                st.add(i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= left && nums[i] <= right) {
                    ans += lefti[i] * righti[i];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 4, 3};
//        int left = 2, right = 3;
//        int []nums = {2,9,2,5,6};
//        int left = 2, right = 8;
        int[] nums = {73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
        int left = 32, right = 69;
//        int[] nums = {34, 46, 51, 92, 50, 61, 49, 82, 4, 4};
//        int left = 18, right = 84;
        Solution solution = new Solution();
        int result = solution.numSubarrayBoundedMax(nums, left, right);
        System.out.println(result);
    }
}
