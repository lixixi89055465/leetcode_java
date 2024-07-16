package zuo.base.class03;

import utils.RandomUtils;

import java.util.Random;

/**
 * 基数排序
 * 桶排序思想下的排序
 * 1）计数排序
 * 2）基数排序
 * 分析：
 * 1)桶排序思想下的排序都是不基于比较的排序
 * 2)时间复杂度为O(N)，额外空间负载度O(M)
 * 3)应用范围有限，需要样本的数据状况满足桶的划分
 */
public class Code02_RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int start, int end, int digit) {
        int radix = 10;
        int bulk[] = new int[end - start + 1];
        for (int d = 1; d <=radix; d++) {
            int count[] = new int[radix];
            for (int j = start; j <= end; j++) {
                int digit1 = getDigit(arr[j], d);
                count[digit1]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] += count[j - 1];
            }
            for (int j = end; j >= start; j--) {
                int digit1 = getDigit(arr[j], d);
                bulk[count[digit1] - 1] = arr[j];
                count[digit1]--;
            }
            for (int i = 0; i < end - start + 1; i++) {
                arr[start + i] = bulk[i];
            }
        }
    }

    private static int getDigit(int value, int d) {
        d--;
        while (d > 0) {
            value /= 10;
            d--;
        }
        return value % 10;
    }

    private static int maxbits(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        int d = 0;
        while (maxValue > 0) {
            maxValue /= 10;
            d++;
        }
        return d;
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.generateRandomArray(100, 100);
        int[] copyArr = RandomUtils.copyArray(arr);
        radixSort(arr);
        RandomUtils.sort(copyArr);
        RandomUtils.printArray(arr);
        RandomUtils.printArray(copyArr);
        boolean equal = RandomUtils.isEqual(arr, copyArr);
        System.out.println(equal);
    }
}


