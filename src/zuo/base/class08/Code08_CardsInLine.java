package zuo.base.class08;

public class Code08_CardsInLine {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int s(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        return arr[start] + Math.max(f(arr, start + 1, end), s(arr, start + 1, end));
    }

    public static int f(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        return arr[end] + Math.max(f(arr, start, end - 1), s(arr, start, end - 1));
    }
}
