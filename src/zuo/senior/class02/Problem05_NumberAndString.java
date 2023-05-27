package zuo.senior.class02;

public class Problem05_NumberAndString {
    public String process(int[] chs, int n) {
        if (chs == null || chs.length == 0 || n < 1) {
            return "";
        }
        int cur = 1;
        int base = chs.length;
        int len = 0;
        while (n >= cur) {
            len++;
            n -= cur;
            cur *= base;
        }
        char[] res = new char[len];
        int index = 0;
        int nCur = 0;
        do {
            cur /= base;
            chs[index++] = String.valueOf(1 + n / cur).charAt(0);
            n %= base;
        } while (n > 0);
        return String.valueOf(res);
    }


    public static void main(String[] args) {


    }
}
