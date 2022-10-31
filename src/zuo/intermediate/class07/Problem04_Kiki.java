package zuo.intermediate.class07;

public class Problem04_Kiki {
    public static int minCoin1(int add, int times, int del, int start, int end) {
        if (start > end) {
            return -1;
        }
        return procecss(0, end, add, times, del, start, end * 2, ((end - start) / 2) * add);
    }

    /**
     * @param preMoney  之前已经花了多少前
     * @param aim       目标 固定
     * @param add       固定
     * @param times     固定
     * @param del       固定
     * @param cur       当前来到的人气
     * @param limitAim  人气达到什么程度不需要再尝试了     固定
     * @param limitCoin 已经使用的币大到什么成都不要要再尝试了     固定
     * @return
     */
    public static int procecss(int preMoney, int aim, int add, int times, int del, int cur,
                               int limitAim, int limitCoin) {
        if (preMoney > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (cur < 0) {
            return Integer.MAX_VALUE;
        }
        if (cur > limitAim) {
            return Integer.MAX_VALUE;
        }
        if (aim == cur) {
            return preMoney;
        }
        int min = Integer.MAX_VALUE;
        int p1 = procecss(preMoney + add, aim, add, times, del, cur + 2, limitAim, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        // 让人气-2 的方式
        int p2 = procecss(preMoney + del, aim, add, times, del, cur - 2, limitAim, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }
        int p3 = procecss(preMoney + times, aim, add, times, del, cur * 2, limitAim, limitCoin);
        if (p3 != Integer.MAX_VALUE) {
            min = Math.min(min, p3);
        }
        return min;
    }
}
