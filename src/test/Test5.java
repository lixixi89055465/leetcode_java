package test;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

public class Test5 {
    public static String removeDuplicates(String s, int k) {
        // write code here
        if (s == null || k <= 0||s.length()<k) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            char cur = sb.charAt(0);
            int count = 1;
            boolean result = false;
            StringBuilder curSb = new StringBuilder();
            for (int i = 1; i < sb.length(); i++) {
                if (cur == sb.charAt(i)) {
                    count++;
                } else if (count >= k) {
                    result = true;
                    curSb = new StringBuilder(sb.substring(0, i - count) + sb.substring(i));
                    count=1;
                    break;
                } else {
                    count = 1;
                    cur = sb.charAt(i);
                }
            }
            if (count >= k) {
                curSb = new StringBuilder(sb.substring(0, sb.length() - count));
                return curSb.toString();
            }
            if (!result) {
                return sb.toString();
            }
            sb = curSb;
        }

    }


    public static void main(String[] args) {
//        String str = "deeedbbcccbdaa";
        String str = "aaa";
        int k = 3;
        System.out.println(removeDuplicates(str, k));

    }
}
