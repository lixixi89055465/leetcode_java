package leetcode.a1600;

import java.util.Stack;

/**
 * 1678. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 *
 *
 * 提示：
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */
public class S1678interpret {
    protected static class Solution {
        public String interpret(String command) {
            char[] strs= command.toCharArray();
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                if('('==strs[i]){
                    stack.push(i);
                }else if(')'==strs[i]){
                    int top=stack.pop();
                    if(top==i-1){
                        sb.append('o');
                    }
                }else{
                   sb.append(strs[i]);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        String command = "G()(al)";
//        String command = "G()()()()(al)";
        String command = "(al)G(al)()()G";
        Solution solution = new Solution();
        String result = solution.interpret(command);
        System.out.println(result);
    }
}
