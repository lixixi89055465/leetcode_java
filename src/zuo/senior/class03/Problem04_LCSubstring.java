package zuo.senior.class03;

public class Problem04_LCSubstring {
    private static String lcst2(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int row = 0;
        int col = str2.length - 1;
        int i, j;
        int end = 0;
        int len = 0;
        int max = 0;

        while (row < str1.length) {
            i = row;
            j = col;
            while (i < str1.length && j < str2.length) {
                if (str1[i] != str2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {

    }
}