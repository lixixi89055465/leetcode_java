package leetcode.a2500;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/12 10:50
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 2576. 求出最多标记下标
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
 * <p>
 * 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
 * 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,4]
 * 输出：2
 * 解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
 * 没有其他更多可执行的操作，所以答案为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [9,2,5,4]
 * 输出：4
 * 解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
 * 第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
 * 没有其他更多可执行的操作，所以答案为 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [7,6,8]
 * 输出：0
 * 解释：没有任何可以执行的操作，所以答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class M2576maxNumOfMarkedIndices {
    private static class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int mid = n / 2;
            int left = 0;
            int right = mid;
            int dLeft = 0;
            int res = 0;
            while (left < mid && right < n) {
                dLeft = nums[left] * 2;
                if (dLeft <= nums[right]) {
                    res += 2;
                    left++;
                    right++;
                } else {
                    right++;
                }
            }
            return res;

        }

//        private int findMaxRight(int[] nums, int value) {
//            int left = 0, right = nums.length - 1;
//            while (left < right) {
//                int mid = left + (right - left + 1) / 2;
//                if (nums[mid] == value) {
//                    return mid;
//                } else if (nums[mid] > value) {
//                    right = mid - 1;
//                } else if (nums[mid] < value) {
//                    left = mid;
//                }
//            }
//            return left + 1 == nums.length ? -1 : left + 1;
//        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{9, 2, 5, 4};
//        int[] nums = new int[]{3,5,2,4};
//        int[] nums = new int[]{7,6,8};
        int[] nums = new int[]{
                57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50, 95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92
        };
        Solution solve = new Solution();
        int res = solve.maxNumOfMarkedIndices(nums);
        System.out.println(res);

    }
}
