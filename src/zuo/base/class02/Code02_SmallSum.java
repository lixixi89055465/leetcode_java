package zuo.base.class02;

public class Code02_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);

    }

    private static int process(int[] arr, int L, int R) {
        int mid = L + ((R - L) >> 1);
        int s1 = process(arr, L, mid);
        int s2 = process(arr, L, mid);
        return merge(arr, L, mid, R) + s1 + s2;
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int s = 0;
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L, p2 = mid + 1;
        int result = 0;
        while (i < arr.length && p1 <= mid && p2 <= R) {
            result += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return result;
    }
}
