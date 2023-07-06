package ZJ;

import java.util.Arrays;

public class ZJ31nextPermutation {
    private static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }
            int end = nums.length - 2;
            while (end >= 0 && nums[end] >= nums[end + 1]) {
                end -= 1;
            }
            if (end == -1) {
                reverseArr(nums, 0, nums.length - 1);
                return;
            }
            int swapIndex = -1;
            for (int i = nums.length - 1; i > end; i--) {
                if (nums[end] < nums[i]) {
                    swapIndex = i;
                    break;
                }
            }
            swap(nums, end, swapIndex);
            reverseArr(nums, end + 1, nums.length - 1);
            System.out.println(nums);
        }

        private void reverseArr(int[] nums, int left, int right) {
            int tmp = 0;
            while (left < right) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{3,2,1};
//        int[] nums = new int[]{1, 1, 5};
//        int[] nums = new int[]{1, 3, 2};
        int[] nums = new int[]{3, 2, 1};
        solve.nextPermutation(nums);
    }
}
