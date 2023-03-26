package zuo.base.class03;

public class Code02_RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[digit];
            for (int i = L; i <= R; i++) {
                int j = getDigit(arr[i], d);
                count[j]++;
            }
            for (int i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }
            for (int i = R; i >= L; i--) {
                int j = getDigit(arr[i], d);
                bucket[count[j]--] = arr[i];
                count[j]--;
            }
            for (int i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int i, int d) {
        d--;
        while (d > 0) {
            i /= 10;
            d--;
        }
        return i % 10;
    }

    private static int maxbits(int[] arr) {
        return 0;
    }
}


