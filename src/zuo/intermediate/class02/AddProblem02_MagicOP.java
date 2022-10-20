package zuo.intermediate.class02;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 请保证所有字符串都是小写字母组成
 */
public class AddProblem02_MagicOP {

    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += (double) arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += (double) arr2[i];
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
            sumMore = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumMore = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int i = 0; i < arrMore.length; i++) {
            double cur = arrMore[i];
            if (cur < avg(sumMore, moreSize)
                    && cur > avg(sumLess, lessSize)
                    && !setLess.contains(arrMore[i])) {
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

    private static double avg(double sum2, int length) {
        return sum2 / (double) length;
    }


    public static void main(String[] args) {
        int[] arr1 = {10, 31, 41, 51, 61, 21};
        int[] arr2 = {12, 32, 42, 52, 62, 22};
        System.out.println(maxOps(arr1, arr2));
    }
}
