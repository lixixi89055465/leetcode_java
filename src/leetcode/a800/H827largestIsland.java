package leetcode.a800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

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
            int res = 1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    dfs(i, j, i * n + j + 100, map, grid, m, n);
                    res = Math.max(res, map.getOrDefault(i * n + j + 100, 0));
                }
            }
            PriorityQueue<Integer> maxTwoV = new PriorityQueue<>(4, (e1, e2) -> e2 - e1);
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 3 && j == 1) {
                        System.out.println('1');
                    }
                    if (grid[i][j] == 0) {
                        set.add(getTopTwo(i + 1, j, map, grid, m, n));
                        set.add(getTopTwo(i - 1, j, map, grid, m, n));
                        set.add(getTopTwo(i, j + 1, map, grid, m, n));
                        set.add(getTopTwo(i, j - 1, map, grid, m, n));
                        for (Integer integer : set) {
                            if (map.containsKey(integer)) {
                                maxTwoV.add(map.get(integer));
                            }
                        }
                        int temp = 1;
                        while (!maxTwoV.isEmpty()) {
                            temp += maxTwoV.poll();
                        }
                        res = Math.max(res, temp);
                        maxTwoV.clear();
                        set.clear();
                    }
                }
            }
            return res;
        }

        private Integer getTopTwo(int i, int j, Map<Integer, Integer> map, int[][] grid, int m, int n) {
            if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
                return -1;
            }
            return grid[i][j];

        }

        private void dfs(int i, int j, int parent, Map<Integer, Integer> map, int[][] grid,
                         int m, int n) {
            if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0 || grid[i][j] != 1) {
                return;
            }
            if (grid[i][j] == 1) {
                map.putIfAbsent(parent, 0);
                map.put(parent, map.get(parent) + 1);
                grid[i][j] = parent;
                dfs(i + 1, j, parent, map, grid, m, n);
                dfs(i - 1, j, parent, map, grid, m, n);
                dfs(i, j + 1, parent, map, grid, m, n);
                dfs(i, j - 1, parent, map, grid, m, n);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] grid = {{1, 0}, {0, 1}};
//        int[][] grid = {{1, 1}, {1, 1}};
//        int[][] grid = {{0, 0}, {0, 0}};
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}};
        int res = s.largestIsland(grid);
        System.out.println(res);
    }
}
