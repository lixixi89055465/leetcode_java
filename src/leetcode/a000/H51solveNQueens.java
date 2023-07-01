package leetcode.a000;


import java.util.*;

/**
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 */
public class H51solveNQueens {
    private static class Solution {
        public List<List<String>> solveNQueens(int n) {
            HashSet<Integer> colSet = new HashSet<>();
            HashSet<Integer> diagnial1 = new HashSet<>();
            HashSet<Integer> diagnial2 = new HashSet<>();
            int[] queue = new int[n];
            List<List<String>> solution = new ArrayList<>();
            dfs(solution, queue, n, 0, colSet, diagnial1, diagnial2);
            return solution;
        }

        //八
        private void dfs(List<List<String>> solution, int[] queue, int n, int row, HashSet<Integer> colSet, HashSet<Integer> diagnial1, HashSet<Integer> diagnial2) {
            if (row == n) {
                List<String> res = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    char[] chs = new char[n];
                    Arrays.fill(chs, '.');
                    chs[queue[i]] = 'Q';
                    res.add(new String(chs));
                }
                solution.add(res);
            }
            for (int col = 0; col < n; col++) {
                if (colSet.contains(col) || diagnial1.contains(row + col) || diagnial2.contains(row - col)) {
                    continue;
                }
                colSet.add(col);
                diagnial1.add(row + col);
                diagnial2.add(row - col);
                queue[row] = col;
                dfs(solution, queue, n, row + 1, colSet, diagnial1, diagnial2);
                colSet.remove(col);
                diagnial1.remove(row + col);
                diagnial2.remove(row - col);
                queue[row] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res);

    }
}
