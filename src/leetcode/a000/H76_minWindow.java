package leetcode.a000;

import java.util.HashMap;
import java.util.Map;

public class H76_minWindow {
    private static class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> tMap = new HashMap<>();
            char[] tChs = t.toCharArray();
            for (int i = 0; i < tChs.length; i++) {
                tMap.put(tChs[i], tMap.getOrDefault(tChs[i], 0) + 1);
            }
            HashMap<Character, Integer> sMap = new HashMap<>();
            char[] sChs = s.toCharArray();
            int res = Integer.MAX_VALUE;
            int left = 0;
            String resV = "";
            for (int i = 0; i < sChs.length; i++) {
                sMap.put(sChs[i], sMap.getOrDefault(sChs[i], 0) + 1);
                while (sContaint(sMap, tMap)) {
                    if (i - left < res) {
                        res = i - left;
                        resV = s.substring(left, i + 1);
                    }
                    sMap.put(sChs[left], sMap.get(sChs[left++]) - 1);
                }
            }
            return resV;
        }

        private boolean sContaint(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
            for (Map.Entry<Character, Integer> e : tMap.entrySet()) {
                if (e.getValue() > sMap.getOrDefault(e.getKey(), 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "a", t = "a";
        String s = "a", t = "aa";
        String res = solution.minWindow(s, t);
        System.out.println(res);

    }
}
