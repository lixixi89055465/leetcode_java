package zuo.intermediate.class08;

public class Problem03 {
    public static int g(int i, int len) {
        int sum = 0;
        if (len == 1) {
            return 1;
        }
        for (int j = i + 1; j < 26; j++) {
            sum += g(j, len - 1);
        }
        return sum;
    }

    public static int f(int len) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += g(i, len);
        }
        return sum;
    }

    public static int kth(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 1; i < chars.length; i++) {
            sum += f(i);
        }
        int pre = chars[0] - 'a';
        for (int i = 1; i < chars.length; i++) {
            for (int j = pre + 1; j < chars[i] - 'a'; j++) {
                sum += g(j, chars.length - i);
            }
            pre=chars[i]-'a';
        }
        return sum;
    }
}
