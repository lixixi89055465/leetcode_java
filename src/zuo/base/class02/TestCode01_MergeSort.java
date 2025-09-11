package zuo.base.class02;

import utils.RandomUtils;

import java.util.Random;

/**
 * 归并排序
 * 1）整体就是一个简单递归，左边排好序、右边排好序、让其整体有序
 * 2）让其整体有序的过程里用了排外序方法
 * 3）利用master公式来求解时间复杂度
 * 4）归并排序的实质
 * 时间复杂度O(N*logN)，额外空间复杂度O(N
 */

public class TestCode01_MergeSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int mid = L + (R - L) / 2;
            RandomUtils.swap(arr, mid, arr[R]);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, L, p[1] + 1);
        }
    }//41, 79, 70,31

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                RandomUtils.swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                RandomUtils.swap(arr, --more, L++);
            } else {
                L++;
            }
        }
        RandomUtils.swap(arr, more, R);
        return new int[]{less + 1, R};
    }


    public static void main(String[] args) {

    }
}
