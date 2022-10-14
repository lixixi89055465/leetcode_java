package zuo.interview_question.class102;

import java.util.Arrays;

public class Code03_MinBoatEvenNumbers {
    public static int minBoat(int[] arr, int limit) {
        Arrays.sort(arr);
        int left0 = 0;
        int left1 = 0;
        int right0 = arr.length - 1;
        int right1 = arr.length - 1;
        int ans = 0;
        while (left0 < right0) {
            while ((arr[left0] & 1) != 0 && left0 < right0) {
                left0++;
            }
            while (((arr[right0] & 1) != 0 || arr[left0] + arr[right0] >= limit) && left0 < right0) {
                right0--;
            }
            if (left0 < right0) {
                ans += 1;
            }
            left0++;
            right0--;
        }
        while (left1 < right1) {
            while ((arr[left1] & 1) == 0 && left1 < right1) {
                left1++;
            }
            while (((arr[right1] & 1) == 0 || arr[left1] + arr[right1] >= limit) && left1 < right1) {
                right1--;
            }
            if (left1 < right1) {
                ans += 1;
            }
            left1++;
            right1--;
        }
        return arr.length - ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 3, 4, 5, 5, 4, 8, 3, 2, 5, 6, 7, 10};
        //1,7;3,5;3,5;3,5;2,6;4,4;
        int limit = 10;
        int result = minBoat(arr, limit);
        System.out.println(result);

    }
}
