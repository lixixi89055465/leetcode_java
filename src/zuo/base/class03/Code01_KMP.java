package zuo.base.class03;

public class Code01_KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < 1) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] str2) {
        int[] next = new int[str2.length + 1];
        int cnt = 0;
        for (int i = 0; i < next.length; i++) {
            if (str2[cnt + 1] == str2[i]) {
                next[i] = ++cnt;
            } else if (cnt > 0) {
                cnt = next[cnt];
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

}
