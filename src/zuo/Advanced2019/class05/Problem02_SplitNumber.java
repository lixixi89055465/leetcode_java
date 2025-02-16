package zuo.Advanced2019.class05;

public class Problem02_SplitNumber {
    public static int way1(int n) {
        if (n < 1) {
            return 0;
        }
        return process(1, n);
    }

    public static int process(int pre, int rest) {
        if (rest == 0) {
            return 1;//之前裂开的方案，构成了第一种
        }
        if (pre > rest) {
            return 0;
        }
        int ways = 0;
        for (int i = 0; i <= rest; i++) {
            ways += process(i, rest - i);
        }
        return ways;
    }

    public static void main(String[] args) {

    }
}
