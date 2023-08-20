package ZJ;

/**
 * 79. 单词搜索
 * 中等
 * 1.6K
 * 相关企业
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [ ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class ZJ079exist {
    private static class Solution {
        public boolean exist(char[][] board, String word) {
            char[] chs = word.toCharArray();
            int n = board.length;
            int m = board[0].length;
            boolean[][] visit = new boolean[n][m];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, n, m, chs, 0, visit)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, int n, int m, char[] chs, int start, boolean[][] visit) {
            if (visit[i][j]) {
                return false;
            }
            if (start == chs.length - 1 && board[i][j] == chs[start]) {
                return true;
            }
            if (board[i][j] != chs[start]) {
                return false;
            }
            visit[i][j] = true;
            if (i != 0 && dfs(board, i - 1, j, n, m, chs, start + 1, visit)) {
                return true;
            }
            if (j != 0 && dfs(board, i, j - 1, n, m, chs, start + 1, visit)) {
                return true;
            }
            if (i != n - 1 && dfs(board, i + 1, j, n, m, chs, start + 1, visit)) {
                return true;
            }
            if (j != m - 1 && dfs(board, i, j + 1, n, m, chs, start + 1, visit)) {
                return true;
            }
            visit[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {{'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
//        char[][] board = {{'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//                String word = "SEE";
//        char[][] board = {{'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//        String word = "ABCB";

//        char[][] board = {{'a'}};
//        String word = "a";
        Solution solve = new Solution();
        System.out.println(solve.exist(board, word));

    }
}
