package interview_question.class01;

public class Code02_CircleCandy {
    public static int minCandy(int[] arr) {
        int n = arr.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[lastIndex(i, n)] >= arr[i] && arr[nextIndex(i, n)] >= arr[i]) {
                minIndex = i;
            }
        }
        int[] nums = new int[n + 1];
        for (int i = 0; i < n + 1; i++, minIndex = nextIndex(minIndex, n)) {
            nums[i] = arr[minIndex];
        }
        left[0] = 1;
        for (int i = 1; i <= n; i++) {
            left[i] = nums[i] > nums[i - 1] ? (left[i - 1] + 1) : 1;
        }
        right[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = nums[i] > nums[i + 1] ? (left[i + 1] + 1) : 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }

    private static int nextIndex(int i, int n) {
        return i == n - 1 ? 0 : i + 1;
    }

    private static int lastIndex(int i, int n) {
        return i == 0 ? n - 1 : i - 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 3, 2};
        System.out.println(minCandy(arr));
    }
}

