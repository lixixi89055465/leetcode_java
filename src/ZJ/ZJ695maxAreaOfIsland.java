package ZJ;

/**
 * 695. 岛屿的最大面积
 * 中等
 * 981
 * 相关企业
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 */
public class ZJ695maxAreaOfIsland {
    private static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] valid = new int[n][m];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        if (valid[i][j] == 0 && grid[i][j] == 1) {
                            res = Math.max(res, dfs(grid, valid, i, j, n, m));
                        }
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int[][] valid, int i, int j, int n, int m) {
            if (valid[i][j] != 0 || grid[i][j] == 0) {
                return 0;
            }
            valid[i][j] = 1;
            int sum = 1;
            if (i != 0) {
                sum += dfs(grid, valid, i - 1, j, n, m);
            }
            if (i != n - 1) {
                sum += dfs(grid, valid, i + 1, j, n, m);
            }
            if (j != 0) {
                sum += dfs(grid, valid, i, j - 1, n, m);
            }
            if (j != m - 1) {
                sum += dfs(grid, valid, i, j + 1, n, m);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
//        int[][] grid =
//                {{1, 1, 0, 0, 0},
//                        {1, 1, 0, 0, 0},
//                        {0, 0, 0, 1, 1},
//                        {0, 0, 0, 1, 1}};
        System.out.println(solve.maxAreaOfIsland(grid));
    }
}
