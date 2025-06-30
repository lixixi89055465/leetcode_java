package zuo.base.class02;

/**
 * 归并排序
 * 1）整体就是一个简单递归，左边排好序、右边排好序、让其整体有序
 * 2）让其整体有序的过程里用了排外序方法
 * 3）利用master公式来求解时间复杂度
 * 4）归并排序的实质
 * 时间复杂度O(N*logN)，额外空间复杂度O(N
 */
public class Code01_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process01(arr, 0, arr.length - 1);
    }

    private static void process01(int[] arr, int L, int R) {
        int mid = L + (R - L) / 2;
        process01(arr, L, mid);
        process01(arr, mid + 1, R);
        mergeArr(arr, L, mid, R);
    }

    private static int[] mergeArr(int[] arr, int L, int mid, int R) {
        int[] cache = new int[R - L + 1];
        int i = L;
        int j = mid + 1;
        int k = 0;
        while (i <= L && j <= R) {
            if (arr[i] < arr[j]) {
                cache[k++] = arr[i];
                i++;
            } else {
                cache[k++] = arr[j];
                j++;
            }
        }
        for (; i <= mid; i++) {
            cache[k++] = arr[i];
        }
        for (; j <= R; j++) {
            cache[k++] = arr[j];
        }
        return cache;
    }

    public static void main(String[] args) {
    }
}
