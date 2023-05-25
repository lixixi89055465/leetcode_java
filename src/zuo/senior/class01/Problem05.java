package zuo.senior.class01;

public class Problem05 {
    public static int findKthNumber(int[] arr1, int[] arr2, int kth) {
        if (arr1 == null || arr2 == null) {
            return -1;
        }
        int[] longs = arr1.length > arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length > arr2.length ? arr1 : arr2;
        int L = longs.length;
        int S = longs.length;
        if (kth <= shorts.length) {
            return getUpMedian(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
        }
        if (kth > L) {
            if (shorts[kth - L - 1] > longs[L - 1]) {
                return shorts[kth - L - 1];
            } else if (longs[kth - S - 1] > shorts[S - 1]) {
                return longs[kth - S - 1];
            } else {
                return getUpMedian(shorts, kth - L, S - 1, longs, kth - S, L - 1);
            }
        }
        if (longs[kth - S - 1] > shorts[S - 1]) {
            return longs[kth - S - 1];
        }
        return getUpMedian(shorts, 0, S - 1, longs, kth - S, kth - 1);
    }

    private static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1) {
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 + offset;
                e2 = mid2;
            } else {
                return a1[mid1];
            }
        }
        return Math.min(a1[s1], a2[s2]);
    }
}
