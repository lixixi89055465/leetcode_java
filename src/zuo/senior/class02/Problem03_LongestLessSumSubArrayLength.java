package zuo.senior.class02;

public class Problem03_LongestLessSumSubArrayLength {
    public static int maxLengthAweSome(int[] arr, int k) {
        int[] minSum = new int[arr.length];
        int[] minSumEnds = new int[arr.length];
        minSum[arr.length - 1] = arr[arr.length - 1];
        minSum[arr.length - 1] = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; i++) {
            if (minSum[i + 1] < 0) {
                minSum[i] = minSum[i + 1] + arr[i];
                minSumEnds[i] = minSumEnds[i + 1];
            } else {
                minSum[i] = arr[i];
                minSumEnds[i] = i;
            }
        }
        int end = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (end < arr.length && sum + minSum[end] <= k) {
                sum += minSum[end];
                end = minSumEnds[end] + 1;
            }
            res = Math.max(res, end - i);
            if (end > i) {
                sum -= arr[i];
            } else {
                end = i + 1;
            }
        }
        return res;
    }
}
