package zuo.base.class11;

public class Code08_CardsInLine {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(
                arr[L] + s(arr, L + 1, R),
                arr[R] + s(arr, L, R - 1));
    }

    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(
                f(arr, i + 1, j),
                f(arr, i, j - 1));
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5};
        System.out.println(f(arr, 0, 3));
        System.out.println(s(arr, 0, 3));
    }
}
