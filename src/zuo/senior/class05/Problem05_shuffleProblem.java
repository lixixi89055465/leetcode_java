package zuo.senior.class05;

import java.util.HashMap;

public class Problem05_shuffleProblem {
    private static int modifyIndex1(int i, int len) {
        if (i <= len / 2) {
            return 2 * i;
        } else {
            return 2 * (i - (len / 2)) - 1;
        }
    }

    private static int modifyIndex2(int i, int len) {
        return (2 * i) % (len + 1);
    }

    private static void shuffle(int[] arr) {
        if (arr != null && arr.length != 0 && (arr.length & 1) == 0) {
            shuffle(arr, 0, arr.length - 1);
        }
    }

    private static void shuffle(int[] arr, int L, int R) {
        while (R - L + 1 > 0) {
            int len = R - L + 1;
            int base = 1;
            int k = 1;
            while (base < len / 3) {
                base *= 3;
                k++;
            }
            int half = (base - 1) / 2;
            int mid = (L + R) / 2;
            rotate(arr, L + half, mid, mid + half);
            cycles(arr, L, base - 1, k);
            L = L + base - 1;
        }
    }

    private static void cycles(int[] arr, int start, int len, int k) {
        for (int i = 0, trigger = 1; i < k; trigger *= 3, i++) {
            int preValue = arr[trigger + start - 1];
            int cur = modifyIndex2(trigger, len);
            while (cur != trigger) {
                int tmp = arr[cur + start - 1];
                arr[cur + start - 1] = preValue;
                preValue = tmp;
                cur = modifyIndex2(cur, len);
            }
            arr[cur + start - 1] = preValue;
        }
    }

    private static void rotate(int[] arr, int L, int mid, int R) {
        int i = L, j = mid;
        while (i < j) {
            swap(arr, i++, j--);
        }
        i = mid + 1;
        j = R;
        while (i < j) {
            swap(arr, i++, j--);
        }
        i = L;
        j = R;
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}