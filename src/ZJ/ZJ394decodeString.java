package ZJ;

/**
 * @author lixiang
 * data 2023/7/28
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class ZJ394decodeString {
    private static class Solution {
        public String decodeString(String s) {
            char[] chs = s.toCharArray();
            Object[] obj = dfs(chs, 0);
            return String.valueOf(obj[0]);
        }

        private Object[] dfs(char[] chs, int start) {
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (int i = start; i < chs.length; i++) {
                if (Character.isLetter(chs[i])) {
                    sb.append(chs[i]);
                } else if (chs[i] == '[') {
                    Object[] obj = dfs(chs, i + 1);
                    String subStr = (String) obj[0];
                    Integer end = (Integer) obj[1];
                    for (int j = 0; j < num; j++) {
                        sb.append(subStr);
                    }
                    i = end;
                    num = 0;
                } else if (Character.isDigit(chs[i])) {
                    num = num * 10 + chs[i] - '0';
                } else if (chs[i] == ']') {
                    return new Object[]{sb.toString(), i};
                }
            }
            return new Object[]{sb.toString(), chs.length};
        }
    }

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
        String s = "2[abc]3[cd]ef";
        Solution solve = new Solution();
        String res = solve.decodeString(s);
        System.out.println(res);
    }
}
