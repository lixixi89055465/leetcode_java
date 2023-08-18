package leetcode.a300;

import java.util.List;

/**
 * 301. 删除无效的括号
 * 提示
 * 困难
 * 862
 * 相关企业
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 输入：s = "()())()"
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 * 提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class H301removeInvalidParentheses {
    private static class Solution {
        public List<String> removeInvalidParentheses(String s) {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        String s = "(a)())()";
        System.out.println(solve.removeInvalidParentheses(s));
    }
}
