package leetcode.a000;

import java.util.Stack;

/**
 * 85. 最大矩形
 */
public class H85maximalRectangle {
    private static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null) {
                return 0;
            }
            int n = matrix.length;
            if (n == 0) {
                return 0;
            }
            int m = matrix[0].length;
            if (m == 0) {
                return 0;
            }
            int[][] left = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == '1') {
                        left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                    }
                }
            }
            int res = 0;
            for (int j = 0; j < m; j++) {
                Stack<Integer> s = new Stack<>();
                int[] up = new int[n];
                int[] down = new int[n];
                for (int i = 0; i < n; i++) {
                    while (!s.isEmpty() && left[s.peek()][j] >= left[i][j]) {
                        s.pop();
                    }
                    up[i] = s.isEmpty() ? -1 : s.peek();
                    s.add(i);
                }
                s.clear();
                for (int i = n - 1; i >= 0; i--) {
                    while (!s.isEmpty() && left[s.peek()][j] >= left[i][j]) {
                        s.pop();
                    }
                    down[i] = s.isEmpty() ? n : s.peek();
                    s.add(i);
                }
                for (int i = 0; i < n; i++) {
                    int height = down[i] - up[i] - 1;
                    int area = height * left[i][j];
                    res = Math.max(res, area);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = new char[][]{{'1'}};
        Solution solution = new Solution();
        int res = solution.maximalRectangle(matrix);
        System.out.println(res);
    }
}
