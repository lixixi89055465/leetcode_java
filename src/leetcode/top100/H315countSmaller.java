package leetcode.top100;

import java.util.List;

/**
 * @PackageName:leetcode.top100
 * @Date 2023/8/30 18:44
 * @Description: https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 * 315. 计算右侧小于当前元素的个数
 * 困难
 * 1K
 * 相关企业
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class H315countSmaller {
    private static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] nums = {5, 2, 6, 1};
        System.out.println(solve.countSmaller(nums));
    }
}
