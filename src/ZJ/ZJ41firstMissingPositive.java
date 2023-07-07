package ZJ;

public class ZJ41firstMissingPositive {
    private static class Solution {
        public int firstMissingPositive(int[] nums) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = new int[]{3, 4, -1, 1};
        int result = solve.firstMissingPositive(nums);
        System.out.println(result);
    }
}
