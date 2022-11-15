package zuo.senior.class01;

public class Problem05_findKthMinNumber {
    public static int findKthNumber(int[] arr1, int[] arr2, int kth) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("You arr is null");
        }
        if (kth < 1 || kth > arr1.length + arr2.length) {
            throw new RuntimeException("You arr is null");
        }
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
        int L = longs.length;
        int s = shorts.length;
        if (kth <= s) {
            return getUpMedian(shorts, 0, kth - 1, longs, 0, kth - 1);
        }
        if (kth > L) {
            if (shorts[kth - L - 1] >= longs[L - 1]) {
                return shorts[kth - L - 1];
            }
            if (longs[kth - s - 1] >= shorts[s - 1]) {
                return longs[kth - s - 1];
            }
            return getUpMedian(shorts, kth - L, s - 1, longs, kth - s, L - 1);
        }
        //2 )
        if (longs[kth - s - 1] >= shorts[s - 1]) {
            return longs[kth - s - 1];
        }
        return getUpMedian(shorts, 0, s - 1, longs, kth - s, kth - 1);

    }

    private static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1) {
            mid1 = (e1 + s1) / 2;
            mid2 = (e2 + s2) / 2;
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 + offset;
                e2 = mid2;
            }else{
                return a1[mid1];
            }
        }
        return Math.min(a1[s1],a2[s2]);
    }

}
