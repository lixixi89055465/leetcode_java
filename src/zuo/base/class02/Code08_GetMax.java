package zuo.base.class02;

/**
 * 链表删除
 */
public class Code08_GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr, left, mid - 1);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
