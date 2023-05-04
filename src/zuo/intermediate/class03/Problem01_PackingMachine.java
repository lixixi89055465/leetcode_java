package zuo.intermediate.class03;

public class Problem01_PackingMachine {
    public static int MinOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % size != 0) {
            return -1;
        }
        int leftSum = 0;
        int avg = sum / arr.length;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = leftSum - avg * i;
            int right = sum - left - (arr.length - i) * avg;
            if (left < 0 && right < 0) {
                result = Math.max(result, Math.abs(left) + Math.abs(right));
            } else {
                result = Math.max(result, Math.max(Math.abs(left), Math.abs(right)));
            }
            leftSum += arr[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
