package test;

/**
 * @author lixiang
 * data 2023/7/19
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class Test04 {
    public String test01(String s, String t) {
        int[] map = new int[128];
        int[] curmap = new int[128];
        char[] tChs = t.toCharArray();
        for (char c : tChs) {
            map[c] += 1;
        }
        char[] sChs = s.toCharArray();
        int left = 0;
        int right = 0;

        String res = "";
        int resLen = Integer.MAX_VALUE;
        while (left < right && right < sChs.length) {
            while (!isValid(curmap, map) && right < sChs.length) {
                curmap[sChs[right]] += 1;
                right += 1;
            }
            resLen = Math.min(resLen, right - left);
            res = s.substring(left + 1, right + 1);
            while (map[sChs[left]] == 0 || curmap[sChs[left]] > map[sChs[left]]) {
                left += 1;
                curmap[sChs[left]] -= 1;
                continue;
            }
            resLen = Math.min(resLen, right - left);
            left += 1;
            res = s.substring(left, right);
        }
        return res;
    }

    private boolean isValid(int[] curMap, int[] map) {

        return false;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        Test04 test04 = new Test04();
        System.out.println(test04.test01(s, t));
    }
}
