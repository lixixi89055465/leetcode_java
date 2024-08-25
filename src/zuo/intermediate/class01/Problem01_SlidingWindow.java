package zuo.intermediate.class01;

import java.util.Arrays;

/**
 * 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n－1]，
 * 给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
 */
public class Problem01_SlidingWindow {
    public static int processs(int[] arr, int len) {
        Arrays.sort(arr);
        int left = 0, right = 0;
        int sumA = 0;
        int res = 0;
        int count = 0;
        while (right < arr.length && left <= right) {
            while (right < arr.length && arr[right] - arr[left] < len) {
                count++;
                right++;
                res = Math.max(res, count);
            }
            left++;
            count--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 13, 24, 35, 46, 57, 60, 72, 87};
        int result = processs(arr, 20);
        System.out.println(result);

    }
}
