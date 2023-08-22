package leetcode.a300;


import java.util.*;

/**
 * 301. 删除无效的括号
 * 提示
 * 困难
 * 864
 * 相关企业
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 * <p>
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 * <p>
 * 输入：s = ")("
 * 输出：[""]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class H301removeInvalidParentheses {
    private static class Solution {
        public List<String> removeInvalidParentheses(String s) {
            char[] chs = s.toCharArray();
            int lRemove = 0, rRemove = 0;
            int left = 0, right = 0;
            int other = 0;
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == '(') {
                    left += 1;
                } else if (chs[i] == ')') {
                     left-=1;
                } else {
                    other++;
                }
                if (left <0) {
                    rRemove += 1;
                    left=0;
                }
            }
            lRemove += left;
            int n = s.length() - lRemove - rRemove - other;
            Set<String> res = new HashSet<>();
            dfs(chs, 0, lRemove, rRemove, res, new LinkedList<String>(), n / 2, n / 2);
            return new ArrayList<>(res);
        }

        private void dfs(char[] chs, int index, int lRemove, int rRemove, Set<String> res, LinkedList<String> stack, int left, int right) {
            if (index > chs.length) {
                return;
            }
            if (left < 0 || right < 0 || left > right) {
                return;
            }
            if (lRemove == 0 && rRemove == 0 && left == 0 && right == 0) {
                res.add(String.join("",stack) + (index < chs.length ? String.valueOf(chs, index, chs.length - index) : ""));
                return;
            }
            if (chs[index] == '(') {
                if (left > 0) {
                    stack.addLast("(");
                    dfs(chs, index + 1, lRemove, rRemove, res, stack, left - 1, right);
                    stack.pollLast();
                }
                if (lRemove > 0) {
                    dfs(chs, index + 1, lRemove - 1, rRemove, res, stack, left, right);
                }
            } else if (chs[index] == ')') {
                if (right > left) {
                    stack.addLast(")");
                    dfs(chs, index + 1, lRemove, rRemove, res, stack, left, right - 1);
                    stack.pollLast();
                }
                if (rRemove > 0) {
                    dfs(chs, index + 1, lRemove, rRemove - 1, res, stack, left, right);
                }
            } else {
                stack.addLast(String.valueOf(chs[index]));
                dfs(chs, index + 1, lRemove, rRemove, res, stack, left, right);
                stack.pollLast();
            }
        }

    }


    public static void main(String[] args) {
        Solution solve = new Solution();
//        String s = "()())())";
//        String s = ")(";
//        String s = ")()";
//        String s = "()(a))())b()";
//        String s = "()())())())))";
//        String s = "()a(";
//        String s="()())()";
        String s = "(a)())()";
//        String s = "(()";
        List<String> res = solve.removeInvalidParentheses(s);
        System.out.println(res);
    }
}
