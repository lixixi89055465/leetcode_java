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
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 2);
        process01(arr, L, mid);
        process01(arr, mid + 1, R);
        mergeArr(arr, L, mid, R);
    }

    private static void mergeArr(int[] arr, int L, int mid, int R) {
        int[] cache = new int[R - L + 1];
        int index = 0;
        int i, j;
        for (i = L, j = mid + 1; i <= mid && j <= R; ) {
            if (arr[i] < arr[j]) {
                cache[index++] = arr[i];
                i++;
            } else {
                cache[index++] = arr[j];
                j++;
            }
        }
        for (; i <= mid; i++) {
            cache[index++] = arr[i];
        }
        for (j = mid + 1; j <= R; i++) {
            cache[index++] = arr[j];
        }
        index=0;
        for (int k = L; k <= R; k++) {
            arr[k] = cache[index++];
        }
    }

    public static void main(String[] args) {
    }
}
