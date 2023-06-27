package leetcode.a000;

import java.util.ArrayList;
import java.util.List;

public class M54spiralOrder {


    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int left = 0, right = m - 1, top = 0, low = n - 1;
            List<Integer>res = new ArrayList<>();
            while (left < right && top < low) {
                //top
                for (int i = left; i < right; i++) {
                    res.add(matrix[top][i]);
                }
                for (int i = top; i < low; i++) {
                    res.add( matrix[i][right]);
                }
                for (int i = right; i > left; i--) {
                    res.add(matrix[low][i]);
                }
                for (int i = low; i > top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                right--;
                top++;
                low--;
            }
            if (low == top) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[low][i]);
                }
            } else if (right == left) {
                for (int i = top; i <= low; i++) {
                    res.add(matrix[i][left]);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution solution = new Solution();
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println(res);
    }
}
