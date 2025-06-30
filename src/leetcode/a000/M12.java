package leetcode.a000;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月26日 21:02
 * 项目名称: leetcode_java
 * 文件名称: M12
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 *
 * @Copyright:
 */
public class M12 {
    public int minTime(int[] time, int m) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < time.length; i++) {
            r += time[i];
        }
        int mid = 0;
        while (l < r) {
            boolean flag = check(time, m, mid);
            if (flag) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }

    private boolean check(int[] time, int m, int top) {
        int sum = 0;
        int timeMax = 0;
        int i = 0;
        for (; i < time.length; i++) {
            timeMax = Math.max(timeMax, time[i]);
            sum += time[i];
            if (sum - timeMax > top) {
                sum = time[i];
                timeMax = time[i];
                m--;
            }
        }
        if (m > 1) {
            return true;
        } else if (m == 1) {
            return sum - timeMax <= top;
        } else if (m < 0) {
            return false;
        } else {
            return sum == 0;
        }
    }

    public static void main(String[] args) {
        M12 s = new M12();
//        int[] time = {1, 2, 3, 3};
//        int m = 2;
//        int[] time = {1, 2, 3, 3, 3};
//        int m = 2;
        int[] time = {50, 47, 68, 33, 35, 84, 25, 49, 91, 75};
        int m = 1;
        int res = s.minTime(time, m);
        System.out.println(res);
    }
}
