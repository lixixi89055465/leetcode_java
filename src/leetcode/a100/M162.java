package leetcode.a100;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * 创建人: @author xxxxxx
 * 创建时间: 2025年06月28日 10:25
 * 项目名称: leetcode_java
 * 文件名称: M162
 * 文件描述: @Description:
 * site:
 * All rights Reserved, Designed By xxxxxx
 * 162. 寻找峰值
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @Copyright:
 */

public class M162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (compare(nums, mid)) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }
        }
        return l;
    }

    private boolean compare(int[] nums, int mid) {
        if (mid == 0) {
            return nums[mid] > nums[mid + 1];
        }
        if (mid == nums.length - 1) {
            return nums[mid] > nums[mid - 1];
        }
        if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};
//        int[] nums = {1};
        int[] nums = {1,2};
        M162 m162 = new M162();
        int res = m162.findPeakElement(nums);
        System.out.println(res);
    }
}
