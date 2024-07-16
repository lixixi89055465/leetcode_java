package zuo.base.class02;

/**
 * 归并排序的扩展
 * 小和问题和逆序对问题
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组
 * 的小和。求一个数组 的小和。
 * 例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左
 * 边比4小的数，1、3; 2左边比2小的数，1; 5左边比5小的数，1、3、4、
 * 2; 所以小和为1+1+3+1+1+3+4+2=16
 * 逆序对问题 在一个数组中，左边的数如果比右边的数大，则折两个数
 * 构成一个逆序对，请打印所有逆序 对。
 */
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
