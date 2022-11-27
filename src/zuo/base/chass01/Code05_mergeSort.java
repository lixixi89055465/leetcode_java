package zuo.base.chass01;


public class Code05_mergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + (R - L) >> 1;
        sortProcess(arr, L, M);
        sortProcess(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        while (p1 <= M || p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1];
        }
        while (p2 <= R) {
            help[i++] = arr[p2];
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            arr[L + i1] = help[i1];
        }
    }

}
