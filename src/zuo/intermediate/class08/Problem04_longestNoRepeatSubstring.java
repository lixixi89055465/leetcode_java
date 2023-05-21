package zuo.intermediate.class08;

public class Problem04_longestNoRepeatSubstring {
    public static int maxUnique(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int res = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < chas.length; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            res = Math.max(res, cur);
            map[chas[i]] = i;
        }
        return res;
    }

}
