package leetcode.a1900;

/**
 * 1957. 删除字符使字符串变好
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * <p>
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * <p>
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leeetcode"
 * 输出："leetcode"
 * 解释：
 * 从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
 * 没有连续三个相同字符，所以返回 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "aaabaaaa"
 * 输出："aabaa"
 * 解释：
 * 从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
 * 从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
 * 没有连续三个相同字符，所以返回 "aabaa" 。
 * 示例 3：
 * <p>
 * 输入：s = "aab"
 * 输出："aab"
 * 解释：没有连续三个相同字符，所以返回 "aab" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 */
public class S1957 {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        char pre1 = '/', pre2 = '/';
        char[] chs = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != pre1 || chs[i] != pre2) {
                pre1=pre2;
                pre2=chs[i];
                res.append(chs[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        S1957 s = new S1957();
        String str = "aaabaaaa";
        String res = s.makeFancyString(str);
        System.out.println(res);
    }
}
