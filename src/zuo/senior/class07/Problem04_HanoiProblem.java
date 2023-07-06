package zuo.senior.class07;

public class Problem04_HanoiProblem {
    private static int process(int[] arr, int i, int from, int other, int to) {
        if (i == -1) {
            return 0;
        }
        if (arr[i] != from && arr[i] != to) {
            return -1;
        }
        if (arr[i] == from) {
            return process(arr, i - 1, from, to, other);
        } else {
            int rest = process(arr, i - 1, other, from, to);
            if (rest == -1) {
                return -1;
            }
            return rest + (1 << i);
        }
    }

    public static void main(String[] args) {

    }
}
