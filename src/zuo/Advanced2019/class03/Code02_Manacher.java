package zuo.Advanced2019.class03;

public class Code02_Manacher {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int C = -1;
        int[] nextArr = new int[s.length()];
        int R = -1;
        char[] str = manacherString(s);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            nextArr[i] = R > i ? Math.min(nextArr[2 * C - i], R - i) : 1;
            while (i + nextArr[i] < str.length && i - nextArr[i] > -1) {
                if (str[i + nextArr[i]] == str[i - nextArr[i]]) {
                    nextArr[i]++;
                } else {
                    break;
                }
            }
            if (i + nextArr[i] > R) {
                R = i + nextArr[i];
                C = i;
            }
            max=Math.max(max,nextArr[i]);
        }
        return max-1;
    }
}
