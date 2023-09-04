package leetcode.top100;

import java.util.Arrays;

/**
 * @PackageName:leetcode.top100
 * @Date 2023/9/1 17:06
 * @Description: https://zhuanlan.zhihu.com/p/95902286
 */
public class QuickPower {
    public static int process02(int a, int power) {
        int ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= a;
            }
            a *= a;
            power >>= 1;
        }
        return ans;
    }

    public static int process01(int a, int power) {
        if (power == 0) {
            return 1;
        } else if ((power & 1) == 1) {
            return process01(a, power - 1) * a;
        } else {
            int temp = process01(a, power / 2);
            return temp * temp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {5, 6, 4, 1, 1, 9};
//        Arrays.sort(nums, 0, 3);
//        System.out.println(nums);
        System.out.println(process01(2, 10));
        System.out.println(process02(2, 10));
    }
}
