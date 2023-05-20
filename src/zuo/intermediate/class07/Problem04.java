package zuo.intermediate.class07;

public class Problem04 {
    public static int minCoin1(int add, int times, int del, int start, int end) {
        if (start > end) {
            return -1;
        }
        return procecss(0, end, add, times, del, start, end * 2, ((end - start) / 2) * add);
    }

    private static int procecss(int preMoney, int aim, int add, int times, int del, int cur,
                                int limitAim, int limitCoin) {
        if (preMoney > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (cur < 0) {
            return Integer.MAX_VALUE;
        }
        if (aim == cur) {
            return preMoney;
        }
        int min = Integer.MAX_VALUE;
        //人气+2
        int p1 = procecss(preMoney + add, aim, add, times, del, cur + add, limitAim, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        //人气-2的方式
        int p2 = procecss(preMoney + del, aim, add, times, del, cur - del, limitAim, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }
        int p3 = procecss(preMoney + times, aim, add, times, del, cur * times, limitAim, limitCoin);
        if (p3 != Integer.MAX_VALUE) {
            min = Math.min(min, p3);
        }
        return min;
    }
}

