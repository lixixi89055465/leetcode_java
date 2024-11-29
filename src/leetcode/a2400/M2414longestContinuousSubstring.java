package leetcode.a2400;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/19 18:15
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 2414. 最长的字母序连续子字符串的长度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * <p>
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abacaba"
 * 输出：2
 * 解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
 * "ab" 是最长的字母序连续子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abcde"
 * 输出：5
 * 解释："abcde" 是最长的字母序连续子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class M2414longestContinuousSubstring {
    private static class Solution {
        public int longestContinuousSubstring(String s) {
            char[] chs = s.toCharArray();
            int res = 1;
            int count = 1;
            for (int i = 1; i < chs.length; i++) {
                if (chs[i] - 1 == chs[i - 1]) {
                    count++;
                    res = Math.max(res, count);
                } else {
                    count = 1;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        String s = "abacaba";
        String s = "abcde";
        int res = solve.longestContinuousSubstring(s);
        System.out.println(res);
    }
}
