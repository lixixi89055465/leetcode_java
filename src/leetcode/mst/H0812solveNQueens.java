package leetcode.mst;


import java.util.*;

/**
 * 面试题 08.12. 八皇后
 * 提示
 * 困难
 * 188
 * 相关企业
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[
 * [
 * ".Q..",
 * "...Q",
 * "Q...",
 * "..Q.
 * "],
 * ["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class H0812solveNQueens {
    private static class Solution {
        public List<List<String>> solveNQueens(int n) {
            HashSet<Integer> colset = new HashSet<>();
            Set<Integer> xiejia = new HashSet<>();
            Set<Integer> xiejian = new HashSet<>();
            List<List<String>> res = new ArrayList<>();
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append('.');
            }
            queue(res, 0, colset, xiejia, xiejian, n, stack, sb);
            return res;
        }

        private void queue(List<List<String>> res, int row, HashSet<Integer> colset, Set<Integer> xiejia, Set<Integer> xiejian, int n, Stack<String> stack, StringBuilder sb) {
            if (row == n) {
                ArrayList<String> tmp = new ArrayList<>(Arrays.asList(new String[n]));
                Collections.copy(tmp, stack);
                res.add(tmp);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (colset.contains(i) || xiejia.contains(row + i) || xiejian.contains(row - i)) {
                    continue;
                }
                sb.replace(i, i+1, "Q");
                stack.add(sb.toString());
                sb.replace(i, i+1, ".");
                colset.add(i);
                xiejia.add(row + i);
                xiejian.add(row - i);
                queue(res, row + 1, colset, xiejia, xiejian, n, stack, sb);
                colset.remove(i);
                xiejia.remove(row + i);
                xiejian.remove(row - i);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int n = 4;
        List<List<String>> res = solve.solveNQueens(n);
        System.out.println(res);

    }
}
