package ZJ;

public class ZJ41firstMissingPositive {
    private static class Solution {
        public int firstMissingPositive(int[] nums) {
            int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 != nums[i] && nums[i] > 0) {
                    swapNum(nums, i);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 != nums[i]) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void swapNum(int[] nums, int index) {
            int tmp = nums[index];
            nums[index] = -1;
            while (tmp > 0 && tmp <= nums.length && nums[tmp - 1] != tmp) {
                index = nums[tmp - 1];
                nums[tmp - 1] = tmp;
                if (index <= 0 || index > nums.length) {
                    break;
                }
                tmp = index;
            }
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
//        int[] nums = new int[]{3, 4, -1, 1};
//        int[] nums = new int[]{7,8,9,11,12};
//        int[] nums = new int[]{1,2,0};
//        int[] nums = new int[]{1, 1};
        int[] nums = new int[]{2, 1};
        int res = solve.firstMissingPositive(nums);
        System.out.println(res);
    }
}
