package zuo.intermediate.class06;

public class Problem05_Light {
    public static int minLight(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == str.length) {
                    break;
                } else {
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }

                }
            }
        }
        return light;
    }

    public static void main(String[] args) {
        String s = "X...XXX...X.X.";
        int result = minLight(s);
        System.out.println(result);
    }
}
