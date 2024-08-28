package zuo.intermediate.class07;

public class Problem04 {
    public static int minCoin1(int add, int times, int del, int start, int end) {
        if (start > end) {
            return -1;
        }
        return procecss(0, end, add, times, del, start, end * 2, ((end - start) / 2) * add);
    }

    private static int procecss(int pre, int aim, int add, int times, int del, int finish,
                                int limitAim, int limitCoin) {
        if (pre > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (aim < 0) {
            return Integer.MAX_VALUE;
        }
        if (aim > limitAim) {
            return Integer.MAX_VALUE;
        }
        if (aim == finish) {
            return pre;
        }
        int min = Integer.MAX_VALUE;
        int p1 = procecss(pre + add, aim - 2, add, times, del, finish, limitAim, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        int p2 = procecss(pre + del, aim + 2, add, times, del, finish, limitAim, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }
        if ((aim & 1) == 0) {
            int p3 = procecss(pre + times, aim / 2, add, times, del, finish, limitAim, limitCoin);
            if (p3 != Integer.MAX_VALUE) {
                min = Math.min(min, p3);
            }
        }
        return min;
    }
}
