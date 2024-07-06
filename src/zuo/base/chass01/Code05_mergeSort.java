package zuo.base.chass01;


import utils.RandomUtils;

import java.util.Random;

public class Code05_mergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        subProcess(arr, 0, arr.length - 1);
    }

    private static void subProcess(int[] arr, int L, int R) {
        if (L == R)
            return;
        int M = L + ((R - L) >> 1);
        subProcess(arr, L, M);
        subProcess(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int p1 = L, p2 = M + 1;
        int i = 0;
        int[] help = new int[R - L + 1];
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr= RandomUtils.generateRandomArray(100, 100);
//        int[] arr = new int[]{-4, 9, 7, 2, 0, -8, 5};
        RandomUtils.printArray(arr);
        int[] copyArr = RandomUtils.copyArray(arr);
        mergeSort(arr);
        RandomUtils.sort(copyArr);
        boolean equal = RandomUtils.isEqual(arr, copyArr);
        System.out.println(equal);
        RandomUtils.printArray(arr);
        RandomUtils.printArray(copyArr);


    }

}
