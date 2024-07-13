package zuo.base.class02;

import jdk.management.resource.internal.ResourceNatives;
import utils.RandomUtils;

import java.util.Random;

public class Code06_QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            RandomUtils.swap(arr, R, L+(int) ((R - L + 1) * Math.random()));
            int p[] = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }

    }//41, 79, 70,31

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                RandomUtils.swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                RandomUtils.swap(arr, --more, L);
            } else {
                L++;
            }
        }
        RandomUtils.swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    public static void main(String[] args) {
        int arr[] = RandomUtils.generateRandomArray(100,100);
        int[] copyArr = RandomUtils.copyArray(arr);
        quickSort(arr);
        RandomUtils.sort(copyArr);
        boolean equal = RandomUtils.isEqual(arr, copyArr);
        RandomUtils.printArray(arr);
        RandomUtils.printArray(copyArr);
        System.out.println(equal);
    }
    //41 79 70 31 12 18 -26 22 14 -76 -72 -69 -43 14 -38 -23 65 -5 -44 -39 -42 -17 -13 -13 8 11 -11 -65 -17 -38 -11 -34 -12 -68 -16 -10 -10 -5 -5 -19 -19 -45 -10 -63 0 -14 5 11 28 43 22 30 30 20 13 1 5 33 36 36 37 59 70
}
