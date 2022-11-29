package zuo.base.chass01;

public class Code_12_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        int mid = left + (right - left) >> 1;
        return mergeSort(arr, left, mid) +
                mergeSort(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        int res= 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                res+= arr[p1] * (R - p2+1);
                help[i++] = arr[p1];
                p1++;
            } else {
                help[i++] = arr[p2];
                p2++;
            }
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
        return res;
    }

    public static void main(String[] args) {

    }
}
