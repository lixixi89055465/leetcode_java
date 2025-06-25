package leetcode.a000;

import utils.RandomUtils;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月25日 13:25
 * 项目名称: leetcode_java
 * 文件名称: H31nextPermutation
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 * 31. 下一个排列
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 1,2,4,5,8,7,6
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100*
 * 1,2,4,3,2,1
 *
 * @Copyright:
 */

public class H31nextPermutation {
    private static class Solution {
        public void nextPermutation(int[] nums) {
            boolean flag = false;
            int left = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] >= nums[i + 1]) {
                    continue;
                } else {
                    left = i;
                    for (int j = nums.length - 1; j > i; j--) {
                        if (nums[j] > nums[i]) {
                            int k = nums[i];
                            nums[i] = nums[j];
                            nums[j] = k;
                            break;
                        }
                    }
                    flag = true;
                    break;
                }
            }

            for (int i = left + 1, j = nums.length - 1; i < j; i++, j--) {
                int k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
            }
            RandomUtils.printArray(nums);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 4, 5, 6, 7, 6, 5, 4};
        int[] nums = {3, 2, 1};
        Solution s = new Solution();
        s.nextPermutation(nums);

    }
}

