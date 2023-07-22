package ZJ;

public class ZJ0162findPeakElement {
    private static class Solution {
        public int findPeakElement(int[] nums) {
            int res = getNums(nums, 0, nums.length - 1);
            return res;
        }

        private int getNums(int[] nums, int left, int right) {
            if (right - left < 2) {
                return nums[left] > nums[right] ? left : right;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                return getNums(nums, mid, right);
            } else {
                return getNums(nums, left, mid);
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        int[] nums = new int[]{1, 2, 3, 1};
        int res = solve.findPeakElement(nums);
        System.out.println(res);
    }
}
