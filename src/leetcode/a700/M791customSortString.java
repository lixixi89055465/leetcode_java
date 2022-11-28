package leetcode.a700;

import java.util.Map;
import java.util.TreeMap;

/**
 * 791. 自定义字符串排序
 * 给定两个字符串 order 和 s 。order 的所有字母都是 唯一 的，并且以前按照一些自定义的顺序排序。
 *
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 *
 * 返回 满足这个性质的 s 的任意一种排列 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * 示例 2:
 *
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 */
public class M791customSortString {
    protected static class Solution {
        public String customSortString(String order, String s) {
            TreeMap<Integer, Character> treeMap = new TreeMap<>();
            for (int i = 0; i < order.length(); i++) {
                treeMap.put(i + 1, order.charAt(i));
            }
            int[] map1 = new int[26];
            for (int i = 0; i < s.length(); i++) {
                map1[s.charAt(i) - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            while (!treeMap.isEmpty()) {
                Map.Entry<Integer, Character> integerCharacterEntry = treeMap.pollFirstEntry();
                for (int i = 0; i < map1[integerCharacterEntry.getValue() - 'a']; i++) {
                    sb.append(integerCharacterEntry.getValue().toString());
                }
                map1[integerCharacterEntry.getValue() - 'a'] = 0;
            }
            for (int i = 0; i < 26; i++) {
                if (map1[i] > 0) {
                    for (int j = 0; j < map1[i]; j++) {
                        sb.append(Character.toChars('a' + i));
                    }
                }
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        String order = "cbafg", s = "abcd";
//        String order = "cba", s = "abcd";
        Solution solution = new Solution();
        String s1 = solution.customSortString(order, s);
        System.out.println(s1);
    }
}
