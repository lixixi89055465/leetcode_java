package huawei.OD24_09;

import java.util.Scanner;

/**
 * 2024年华为OD机试真题-提取字符串中的最长数学表达式并计算-Python-OD统一考试（C卷）
 */
public class tqzfczdzcsxbds {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
        String input = "1-2abc1+2+3d233323+3232+323232";
        String[] split = input.split("-|\\+|\\*");
        for (String s : split) {
            System.out.println(s);
        }
        boolean pre = false;
        int maxStart = 0;
        int maxLen = 0;
        int curLen = 0;
        int curStart = 0;
        for (int i = 0; i < split.length; i++) {
            if (isValid(split[i])) {
                if (pre == false) {
                    pre = true;
                    curStart = i;
                } else {
                    curLen = i - curStart + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        maxStart=curStart;
                    }
                }
            } else {
                pre = false;
                curLen = 0;
            }
        }
        System.out.println(maxStart);
    }

    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

}
