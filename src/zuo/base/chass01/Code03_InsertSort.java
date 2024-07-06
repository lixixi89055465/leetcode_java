package zuo.base.chass01;

import utils.RandomUtils;

public class Code03_InsertSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                RandomUtils.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.generateRandomArray(100, 100);
        int[] copyArr = RandomUtils.copyArray(arr);
        selectionSort(arr);
        RandomUtils.sort(copyArr);
        boolean equal = RandomUtils.isEqual(arr, copyArr);
        System.out.println(equal);
        RandomUtils.printArray(copyArr);
        RandomUtils.printArray(arr);
    }
}
