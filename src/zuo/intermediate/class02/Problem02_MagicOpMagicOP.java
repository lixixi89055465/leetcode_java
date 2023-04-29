package zuo.intermediate.class02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 */
public class Problem02_MagicOpMagicOP {

    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0.0;
        for (int i : arr1) {
            sum1 += i;
        }
        double sum2 = 0.0;
        for (int i : arr2) {
            sum2 += i;
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Object> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }
        int moreSize = arrMore.length;//平均值大的集合还剩几个数
        int lessSize = arrLess.length;//平均值小 的集合还剩几个数
        int ops = 0;//操作了
        for (int i = 0; i < arrMore.length; i++) {
            double cur = (double) arrMore[i];
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize) &&
                    !setLess.contains(arrMore[i])) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    private static double avg(double sum1, int length) {
        return sum1 / length;
    }
}
