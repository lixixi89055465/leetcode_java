package zuo.base.class02;

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
