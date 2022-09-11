package base.class11;

import java.util.ArrayList;
import java.util.HashSet;

public class Code07_Knapsack {
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    private static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        if (index == v.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, alreadyW, bag);
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            p2 = p2next + v[index];
        }
        return Math.max(p1, p2);
    }

    public static int process1(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process1(w, v, index + 1, rest);
        int p2 = Integer.MIN_VALUE;
        if (rest >= w[index]) {
            p2 = v[index] + process1(w, v, index + 1, rest - w[index]);
        }
        return Math.max(p1, p2);
    }

}
