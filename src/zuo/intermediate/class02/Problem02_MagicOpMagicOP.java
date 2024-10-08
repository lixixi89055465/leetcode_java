package zuo.intermediate.class02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 给一个包含n个整数元素的集合a，一个包含m个整数元素的集合b。
 * 定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，且操作过
 * 后每个集合的平均值都大大于于操作前。
 * 注意以下两点：
 * 1）不可以把一个集合的元素取空，这样就没有平均值了
 * 2）值为x的元素从集合b取出放入集合a，但集合a中已经有值为x的元素，则a的
 * 平均值不变（因为集合元素不会重复），b的平均值可能会改变（因为x被取出
 * 了）
 * 问最多可以进行多少次magic操作？
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

    public static void main(String[] args) {
        int[] arr1 = {0, 1,  3, 4,  6};
        int[] arr2 = {10, 11, 2,  4, 5 };
        int i = maxOps(arr1, arr2);
        System.out.println(i);
    }
}
