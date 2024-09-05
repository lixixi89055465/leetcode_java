package leetcode.a200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/4 19:27
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 227. 基本计算器 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * <p>
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class M227calculate {
    private static class Solution {
        public int calculate(String s) {
            char[] chs = s.toCharArray();
            int n = chs.length;
            char preChar = '+';
            int num = 0;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(chs[i])) {
                    num = num * 10 + chs[i] - '0';
                }
                if (!Character.isDigit(chs[i]) && chs[i] != ' ' || i == n - 1) {
                    switch (preChar) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    preChar = chs[i];
                    num = 0;
                }
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        String s = " 3+5 / 2 ";
        System.out.println(solve.calculate(s));
    }
}
