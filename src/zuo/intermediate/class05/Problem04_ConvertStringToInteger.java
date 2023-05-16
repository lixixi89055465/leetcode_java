package zuo.intermediate.class05;


public class Problem04_ConvertStringToInteger {
    public static Integer convert(String s) {
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            throw new RuntimeException("can not convert!");
        }
        boolean neg = str[0] == '-' ? true : false;
        int minQ = Integer.MIN_VALUE / 10;
        int minR = Integer.MIN_VALUE % 10;
        int res = 0, cur = 0;
        for (int i = neg ? 1 : 0; i < str.length; i++) {
            cur = '0' - str[i];
            if (res < minQ || (res == minQ && cur < minR)) {
                throw new RuntimeException("can't convert!");
            }
            res = res * 10 + cur;
        }
        if (!neg && res == Integer.MIN_VALUE) {
            throw new RuntimeException("can not convert!");
        }
        return neg ? res : -res;
    }

    private static boolean isValid(char[] str) {
        if (str[0] != '-' && (str[0] < '0' || str[0] > '0')) {
            return false;
        }

        if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
            return false;
        }
        if (str[0] == '0' && str.length > 1) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
