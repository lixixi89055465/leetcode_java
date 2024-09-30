package leetcode.a800;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/making-a-large-island/
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 827. 最大人工岛
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * <p>
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * <p>
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * <p>
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * <p>
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 */
public class H827largestIsland {
    private static class Solution {
        public int largestIsland(int[][] grid) {
            Map<Integer, Integer> map = new HashMap<>();
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    dfs(i, j, map, grid, m, n);
                }
            }

            return 0;
        }

        private void dfs(int i, int j, Map<Integer, Integer> map, int[][] grid, int m, int n) {
            if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != 1) {
                return;
            }
            grid[i][j] = 2;



        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 0}, {0, 1}};
        int res = s.largestIsland(grid);
        System.out.println(res);
    }
}
