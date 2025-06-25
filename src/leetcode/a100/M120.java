package leetcode.a100;

import leetcode.a000.M62;

import java.util.List;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月25日 15:13
 * 项目名称: leetcode_java
 * 文件名称: M120
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright:
 */

public class M120 {
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length()<2){
                return s.length();
            }
            int[] cache = new int[128];
            for (int i = 0; i < 128; i++) {
                cache[i] = -1;
            }
            int res = 0;
            int pre = -1;
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                pre = Math.max(pre, cache[chs[i]]);
                res = Math.max(res, i - pre);
                cache[chs[i]] = i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "abcabcbb";
        String s = "pwwkew";
//        String s = "au";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

