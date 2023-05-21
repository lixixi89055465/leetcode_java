package zuo.intermediate.class08;

public class Problem03 {
    public static int g(int i, int len) {
        int result = 0;
        for (int j = i + 1; j < 26 - len; j++) {
            result += g(j, len - 1);
        }
        return result;
    }

    public static int f(int len) {
        int result = 0;
        for (int i = 0; i < 26 - len; i++) {
            result += g(i, len);
        }
        return result;
    }

    public static int kth(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            sum += f(i);
        }
        for (int i = 0; i < chars[0] - 'a' + 1; i++) {
            sum += g(i, len);
        }
        int pre = chars[0] - 'a' + 1;
        for (int i = 1; i < chars.length; i++) {
            int cur = chars[i] - 'a' + 1;
            for (int j = pre + 1; j < cur; j++) {
                sum += g(j, len - i);
            }
            pre = cur;
        }
        return sum + 1;
    }

}
