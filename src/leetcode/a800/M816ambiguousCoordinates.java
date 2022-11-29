package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

public class M816ambiguousCoordinates {
    protected static class Solution {
        public List<String> ambiguousCoordinates(String s) {
            int n = s.length() - 2;
            List<String> res = new ArrayList<String>();
            s = s.substring(1, s.length() - 1);
            for (int l = 1; l < n; ++l) {
                List<String> lt = getPos(s.substring(0, l));
                if (lt.isEmpty()) {
                    continue;
                }
                List<String> rt = getPos(s.substring(l));
                if (rt.isEmpty()) {
                    continue;
                }
                for (String s1 : lt) {
                    for (String s2 : rt) {
                        res.add("(" + s1 + ", " + s2 + ")");
                    }
                }
            }
            return res;
        }


        public List<String> getPos(String s) {
            List<String> pos = new ArrayList<String>();
            if (s.charAt(0) != '0' || "0".equals(s)) {
                pos.add(s);
            }
            for (int p = 1; p < s.length(); ++p) {
                if ((p != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                    continue;
                }
                pos.add(s.substring(0, p) + "." + s.substring(p));
            }
            return pos;
        }
    }

    public static void main(String[] args) {
        String a = "(123)";
        Solution solution = new Solution();
        List<String> ans = solution.ambiguousCoordinates(a);
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
