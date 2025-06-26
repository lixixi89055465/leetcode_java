package leetcode.a200;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月26日 20:33
 * 项目名称: leetcode_java
 * 文件名称: M200
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright:
 */
public class M200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int mr = grid[0].length;
        if (i < 0 || i >= nr || j < 0 || j >= mr || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        M200 s = new M200();
        char[][] grid =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        s.numIslands(grid);
    }
}
