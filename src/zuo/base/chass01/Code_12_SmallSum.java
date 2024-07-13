package zuo.base.chass01;

import utils.RandomUtils;

import java.util.Random;

public class Code_12_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return mergeSort(arr, left, mid) +
                mergeSort(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L, p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j + L] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.generateRandomArray(100, 100);
        int[] copyArr = RandomUtils.copyArray(arr);

    }
}
