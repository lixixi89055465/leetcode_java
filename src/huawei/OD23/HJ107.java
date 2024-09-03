package huawei.OD23;

import java.util.Scanner;

public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        float a = 0.0f;
//        while (in.hasNext()) { // 注意 while 处理多个 case
        a = in.nextFloat();
        System.out.printf("%.1f", process(a));
//        }

//        float HJ93 = 2.7f;
//        float minDistance = process(HJ93);
//        System.out.printf("%4.1f", minDistance);


    }

    private static float process(float a) {
        float eps = 0.00001f;
        if (a < eps && a > -eps) {
            return 0.0f;
        }
        int fu = a > 0 ? 1 : -1;
        a = fu == 1 ? a : -a;
        float mid = a;
        float lifang = 0.0f;
        float left = a > 1 ? 1 : 0;
        float right = a > 1 ? a : 1;

        while (true) {
            mid = (left + right) / 2;
            lifang = mid * mid * mid;
            if (lifang - a < eps && lifang - a > -eps) {
                return mid * fu;
            } else if (lifang > a) {
                right = mid;
            } else if (lifang < a) {
                left = mid;
            }
        }
    }
}
