package leetcode.a300;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/5 16:41
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 316. 去除重复字母
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的
 * 字典序
 * 最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 */
public class M316removeDuplicateLetters {
    private static class Solution {
        public String removeDuplicateLetters(String s) {

            boolean[] vis = new boolean[26];
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!vis[ch - '0']) {
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                        if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                            vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                            sb.deleteCharAt(sb.length() - 1);
                        } else {
                            break;
                        }
                    }
                    vis[ch - 'a'] = true;
                    sb.append(ch);
                }
                num[ch - 'a'] -= 1;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
//        输出："acdb"
        Solution solve = new Solution();
        System.out.println(solve.removeDuplicateLetters(s));
    }
}
