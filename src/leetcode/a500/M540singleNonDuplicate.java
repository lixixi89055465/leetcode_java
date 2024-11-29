package leetcode.a500;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/11/11 17:22
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 540. 有序数组中的单一元素
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 * <p>
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * 提示:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class M540singleNonDuplicate {
    private static class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int pre = nums[0];
            int len=nums.length;
            boolean flag = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == pre) {
                    flag = true;
                    continue;
                }
                if (!flag) {
                    return pre;
                }
                flag = false;
                pre = nums[i];
            }
            if(nums[len-1]!=nums[len-2]){
                return nums[len-1];
            }
            return nums[0];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        int[] nums = {1, 1, 2};
        int res = s.singleNonDuplicate(nums);
        System.out.println(res);
    }
}

