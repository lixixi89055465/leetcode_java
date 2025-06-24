package leetcode.a000;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 */
public class M3lengthOfLongestSubstring {
    private static class Solution {
        public int lengthOfLongestSubstring1(String s) {
            int[] cache = new int[128];
            for (int i = 0; i < 128; i++) {
                cache[i] = 0;
            }
            int n = s.length();
            char[] chs = s.toCharArray();
            int start = 0, res = 0;
            for (int i = 0; i < chs.length; i++) {
                start = Math.max(start, cache[chs[i]]+1);
                cache[chs[i]] = i;
                res = Math.max(res, i - start + 1);
            }
            return res;
        }

        public int lengthOfLongestSubstring(String s) {
            int[] map = new int[128];
            for (int i = 0; i < 128; i++) {
                map[i] = -1;
            }
            int n = s.length();
            int start = 0;
            char[] chs = s.toCharArray();
            int res = 0;
            for (int i = 0; i < n; i++) {
                int index = chs[i];
                start = Math.max(start, map[index] + 1);
                res = Math.max(res, i - start + 1);
                map[index] = i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
