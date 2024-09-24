package tongyuan;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/24 20:08
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class Test01 {
    private static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums int整型ArrayList
         * @return int整型
         */
        public int reArrangeArray(int[] nums) {
            // write code here
            int res = 1;
            int pre = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[pre]) {
                    continue;
                }
                pre++;
                nums[pre]=nums[i];
                res += 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = {1, 3, 3, 4, 4, 5};
        int re = solve.reArrangeArray(nums);
        System.out.println(re);
    }
}
