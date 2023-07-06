package leetcode.a000;

public class M11maxArea {
    private static class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int left = 0, right = n - 1;
            int res = 0;
            int m = 0;
            while (left < right) {
                m = Math.min(height[left], height[right]);
                res = Math.max(res, (right - left) * m);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = solution.maxArea(height);
        System.out.println(res);
    }
}
