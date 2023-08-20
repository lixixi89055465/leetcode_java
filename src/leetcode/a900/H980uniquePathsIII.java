package leetcode.a900;

import java.util.HashSet;
import java.util.Set;


/**
 * 980. 不同路径 III
 * 困难
 * 321
 * 相关企业
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * <p>
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[
 * [1,0,0,0],
 * [0,0,0,0],
 * [0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 * <p>
 * 输入：[
 * [1,0,0,0],
 * [0,0,0,0],
 * [0,0,0,2]]
 * <p>
 * [1,0,0,0],
 * [0,0,0,0],
 * [0,0,0,0],
 * [0,0,0,0],
 * [0,2,0,0]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 * <p>
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 */
public class H980uniquePathsIII {
    private static class Solution {
        public int uniquePathsIII(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int n = grid.length;
            int m = grid[0].length;
            int count = 0;
            int startx = -1, starty = -1, endx = -1, endy = -1;
            Set<Integer> notValid = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0) {
                        count++;
                    } else if (grid[i][j] == 1) {
                        startx = i;
                        starty = j;
                    } else if (grid[i][j] == 2) {
                        endx = i;
                        endy = j;
                    } else {
                        notValid.add(getHash(i, j));
                    }
                }
            }
            return dfs(grid, startx, starty, endx, endy, 0, count + 1, notValid, n, m);
        }

        private int dfs(int[][] grid, int startx, int starty, int endx, int endy, int curCount, int count, Set<Integer> notValid, int n, int m) {
            if (notValid.contains(getHash(startx, starty))) {
                return 0;
            }

            if (count == curCount && startx == endx && starty == endy) {
                return 1;
            }
            notValid.add(getHash(startx, starty));
            int res = 0;
            if (startx != 0) {
                res += dfs(grid, startx - 1, starty, endx, endy, curCount + 1, count, notValid, n, m);
            }
            if (startx != n - 1) {
                res += dfs(grid, startx + 1, starty, endx, endy, curCount + 1, count, notValid, n, m);
            }
            if (starty != 0) {
                res += dfs(grid, startx, starty - 1, endx, endy, curCount + 1, count, notValid, n, m);
            }
            if (starty != m - 1) {
                res += dfs(grid, startx, starty + 1, endx, endy, curCount + 1, count, notValid, n, m);
            }
            notValid.remove(getHash(startx, starty));
            return res;
        }

        private Integer getHash(int x, int y) {
            return x * 100 + y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = { {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
//        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        Solution solve = new Solution();
        System.out.println(solve.uniquePathsIII(grid));
    }
}
/**
 * [
 * [1,0,0,0],
 * [0,0,0,0],
 * [0,0,0,2]
 * ]
 */
