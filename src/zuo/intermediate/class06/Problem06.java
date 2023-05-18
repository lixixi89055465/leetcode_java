package zuo.intermediate.class06;


public class Problem06 {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i != arr.length; i++) {
            cur += arr[i];
            max = Integer.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

}
