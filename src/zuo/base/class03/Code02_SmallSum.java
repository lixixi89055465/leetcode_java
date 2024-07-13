package zuo.base.class03;

public class Code02_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);

    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return
                process(arr, L, mid)
                        +
                        process(arr, mid + 1, R)
                        +
                        merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int ans = 0;
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
//            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
            ans += arr[p2] >= arr[p2] ? 0 : arr[p1] * (R - p2 + 1);
            help[i++] = arr[p2] >= arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= mid) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < R - L + 1; j++) {
            arr[L + j] = help[j];
        }
        return ans;
    }
}
