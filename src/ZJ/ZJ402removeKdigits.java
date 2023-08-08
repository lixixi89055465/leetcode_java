package ZJ;

import java.util.Stack;

/**
 * 402. 移掉 K 位数字
 * 中等
 * 976
 * 相关企业
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 */
public class ZJ402removeKdigits {
    private static class Solution {
        public String removeKdigits(String num, int k) {
            if (k >= num.length()) {
                return "0";
            }
            Stack<Character> stack = new Stack<Character>();
            char[] chs = num.toCharArray();
            int i;
            for (i = 0; i < chs.length; i++) {
                while (!stack.isEmpty() && stack.peek() > chs[i] && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.add(chs[i]);
            }
            while (k > 0) {
                stack.pop();
                k--;
            }
            StringBuilder sb = new StringBuilder();
            stack.forEach(e -> {
                if (sb.length() != 0 ||e != '0') {
                    sb.append(e);
                }
            });
            if(sb.length()==0){
                return "0";
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        String num = "1432219";
//        int k = 3;
//        String num = "100200";
//        int k = 1;
//        String num = "10";
//        int k = 2;
//        String num = "112";
//        int k = 1;
        String num = "1234567890";
        int k = 9;
        Solution solve = new Solution();

        System.out.println(solve.removeKdigits(num, k));
    }
}
