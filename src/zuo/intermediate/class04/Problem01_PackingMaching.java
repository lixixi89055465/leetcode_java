package zuo.intermediate.class04;

public class Problem01_PackingMaching {

    public int process(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % arr.length != 0) {
            return -1;
        }
        int avg = sum / arr.length;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = sum - leftRest - arr[i] - (arr.length - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest + rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
