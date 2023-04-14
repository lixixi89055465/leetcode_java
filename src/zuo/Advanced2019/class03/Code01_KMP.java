package zuo.Advanced2019.class03;

public class Code01_KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() == 0 || m.length() == 0) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0, i2 = 0;
        int[] nextArray = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (nextArray[i2] == -1) {
                i1++;
            } else {
                i2 = nextArray[i2];
            }
        }
        return i2 == str2.length ? i2 - i1 : -1;

    }

    private static int[] getNextArray(char[] ms) {
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < ms.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
