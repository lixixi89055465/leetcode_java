package ZJ;

import java.util.Random;


public class ZJ912sortArray {
    private static class Solution {
        public int[] sortArray(int[] nums) {
            randomizedQuickSort(nums, 0, nums.length - 1);
            return nums;

        }

        private void randomizedQuickSort(int[] nums, int L, int R) {
            if (L < R) {
                int pos = randomizedPartition(nums, L, R);
                randomizedQuickSort(nums, L, pos);
                randomizedQuickSort(nums, pos, R);
            }
        }

        private int randomizedPartition(int[] nums, int L, int R) {
            int i = new Random().nextInt(R - L + 1) + 1;
            swap(nums, i, R);
            return partition(nums, L, R);
        }

        private int partition(int[] nums, int L, int R) {
            int pivot = nums[R];
            int i = L - 1;
            for (int j = L; j <= R - 1; j++) {
                if (nums[j] <= pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums,i+1,R);
            return i+1;
        }


        public void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

    public static void main(String[] args) {

    }
}
