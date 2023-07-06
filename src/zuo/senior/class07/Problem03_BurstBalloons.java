package zuo.senior.class07;


public class Problem03_BurstBalloons {

    private static int maxCoins1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int N = arr.length;
        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < N; i++) {
            help[i + 1] = arr[i];
        }
        return process(arr, 1, N);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L - 1] * arr[L] * arr[R + 1];
        }
        int max = Math.max(
                arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R),
                arr[R + 1] * arr[R] * arr[R - 1] + process(arr, L, R - 1));
        for (int i = L + 1; i < R; i++) {
            max = Math.max(
                    max, arr[L - 1] * arr[i] * arr[R + 1] + process(arr, L, i - 1) + process(arr, i + 1, R)
            );
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
