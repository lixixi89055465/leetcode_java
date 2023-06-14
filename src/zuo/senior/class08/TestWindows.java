package zuo.senior.class08;

import java.util.HashSet;

public class TestWindows {
    private static int windows(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[] map = new int[256];
        int all = str2.length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length; i++) {
            map[str2[i]]++;
            set.add(str2[i]);
        }
        int left = -1, right = 0;
        int res = Integer.MAX_VALUE;
        while (left < right && right < str1.length) {
            if (all > 0) {
                if (set.contains(str1[right])) {
                    all = map[str1[right]] > 0 ? all - 1 : all;
                    map[str1[right]]--;
                }
                right++;
            } else if (all == 0) {
                res = Math.min(res, right - left - 1);
                left++;
                if (set.contains(str1[left])) {
                    all = map[str1[left]] < 0 ? all : all + 1;
                    map[str1[left]] = map[str1[left]] < 0 ? map[str1[left]] + 1 : map[str1[left]];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "aaaabbcacbba";
        String s2 = "babcab";
        System.out.println(windows(s1, s2));
    }
}
