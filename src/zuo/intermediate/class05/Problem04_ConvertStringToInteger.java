package zuo.intermediate.class05;


public class Problem04_ConvertStringToInteger {
    public static Integer convert(String n) {
        char[] str = n.toCharArray();
        if (!valid(str)) {
            throw new RuntimeException("can not convert!");
        }
        boolean neg = str[0] == '-' ? true : false;
        final int minq = Integer.MIN_VALUE / 10;
        final int minr = Integer.MAX_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = 0; i < str.length; i++) {
            cur = '0' - str[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                throw new RuntimeException("Can not convert");
            }
            res = res * 10 + cur;
        }
        if (!neg && res == Integer.MIN_VALUE) {
            throw new RuntimeException("Can not convert");
        }
        return neg ? res : -res;
    }

    private static boolean valid(char[] str) {
        return false;
    }

    public static void main(String[] args) {

    }
}
