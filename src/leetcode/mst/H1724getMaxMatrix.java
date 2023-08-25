package leetcode.mst;

import org.omg.CORBA.INTERNAL;

/**
 * @PackageName:leetcode.mst
 * @Date 2023/8/24 19:37
 * @Description: https://leetcode.cn/problems/max-submatrix-lcci/
 * 面试题 17.24. 最大子矩阵
 * 提示
 * 困难
 * 187
 * 相关企业
 * 给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 * <p>
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [-1,0],
 * [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 * <p>
 * <p>
 * 说明：
 * <p>
 * 1 <= matrix.length, matrix[0].length <= 200
 */
public class H1724getMaxMatrix {
    private static class Solution {
        public int[] getMaxMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            if (n == 0 || m == 0) {
                return new int[]{};
            }
            int res = Integer.MIN_VALUE;
            int[] dp = new int[m];
            int[] first = new int[m];

            int[] res01 = new int[4];
            for (int len = 1; len < n; len++) {
                for (int i = 0; i < m; i++) {
                    first[i] += matrix[len][i];
                }
                for (int i = 0; i < m; i++) {
                    dp[i] = first[i];
                }
                System.out.println("33333333333");
                res = getRes(matrix, n, m, res, dp, res01, len);
            }
            return res01;
        }

        private int getRes(int[][] matrix, int n, int m, int res, int[] dp, int[] res01, int len) {
            for (int i = 0; i + len < n; i++) {
                int pre = Integer.MIN_VALUE;
                int start = 0;
                for (int j = 0; j < m; j++) {
                    dp[j] -= matrix[i][j];
                    dp[j] += matrix[i + len][j];
                }
                res = getRes(n, res, dp, res01, len, i, pre, start);

            }
            return res;
        }

        private int getRes(int n, int res, int[] dp, int[] res01, int len, int i, int pre, int start) {
            for (int j = 0; j < n; j++) {
                if (pre < 0) {
                    start = j;
                    pre = dp[j];
                }

                if (pre > res) {
                    res = pre;
                    res01[0] = i;
                    res01[1] = start;
                    res01[2] = i + len - 1;
                    res01[3] = j;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[][] matrix = {{-1, 0}, {0, -1}};
        int[][] matrix = {
                {9, -8, 1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7}}; //[0,0,2,3]

        int[] res = solve.getMaxMatrix(matrix);
        System.out.println(res);

    }
}
