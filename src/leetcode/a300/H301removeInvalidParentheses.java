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
            Set<String> res01 = process01(s);
            StringBuilder sb = new StringBuilder();
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if(chs[i]=='(') {
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            Set<String> res02 = process01(sb.toString());
//            res01.addAll(res02);
            return new ArrayList<>(res01);
        }

        private Set<String> process01(String s) {
            char[] chs = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            Set<String> res = new HashSet<>();
            res.add("");
            int pre = 0;
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == '(') {
                    stack.add(chs[i]);
                } else if (chs[i] == ')') {
                    if (stack.size() == 0) {
                        if (pre != i) {
                            res = dfs(res, s.substring(pre, i));
                        }
                        pre = i + 1;
                        continue;
                    }
                    stack.pop();
                }else{

                }
            }
            if (pre < s.length() && stack.isEmpty()) {
                Set<String> newRes = new HashSet<>();
                int pre1 = pre;
                res.forEach(e -> {
                            newRes.add(e + s.substring(pre1));
                        }
                );
                res = newRes;
            }
            return res;
        }

        private Set<String> dfs(Set<String> res, String substring) {
            Set<String> newRes = new HashSet<>();
            res.forEach(s -> {
                String e = (s + substring);
                char[] chs = e.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    if (chs[j] == ')') {
                        newRes.add(e.substring(0, j) + e.substring(j + 1, chs.length) + ")");
                    }
                }

            });
            return newRes;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        String s = "()())())";
        String s = ")(";
//        String s = ")()";
//        String s = "()())())()";
//        String s = "()())())())))";
        List<String> res = solve.removeInvalidParentheses(s);
        System.out.println(res);
    }
}
