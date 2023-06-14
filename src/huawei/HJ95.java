package huawei;

import java.util.Scanner;

public class HJ95 {
    private static String[] money1 = new String[]{
            "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        double money = 0.005 + Double.parseDouble(next.trim());
        String res = "人民币";
        int num = (int) money;
        int yi = num / 100000000;
        if (yi > 0) {
            res += getChar(yi) + "亿";
        }
        int wan = (num - yi * 100000000) / 10000;
        if (wan > 0) {
            res += getChar(wan) + "万";
        }
        int ge = (num - yi * 100000000 - wan * 10000);
        if (ge > 0) {
            res += getChar(ge) + "元";
        }
        double xiao = money - (int) money;
        if (xiao < 0.0001) {
            res += "整";
        }
        if (xiao / 0.1 > 1) {
            res += money1[(int) (xiao / 0.1)] + "角";
            xiao -= (int) (xiao / 0.1) * 0.1;
        }
        if (xiao / 0.01 >= 1) {
            res += money1[(int) (xiao / 0.01)] + "分";
        }
        System.out.println(res);
    }

    private static String getChar(int num) {

        String res = "";
        int qian = num / 1000;
        num %= 1000;
        int bai = num / 100;
        num %= 100;
        int shi = num / 10;
        num %= 10;
        int ge = num;
        if (qian != 0) {
            res += money1[qian] + "仟";
        }
        if (bai != 0) {
            res += money1[bai] + "佰";
        }
        if (qian != 0 && bai == 0) {
            res += money1[bai];
        }
        if (shi != 0) {
            if (shi == 1) {
                res += "拾";
            } else {
                res += money1[shi] + "拾";
            }
        }
        if (bai != 0 && shi == 0) {
            res += money1[shi];
        }
        if (ge != 0) {
            res += money1[ge];
        }
        return res;
    }
}
