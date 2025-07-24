package leetcode.a1600;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

/**
 * 1695. 删除子数组的最大得分
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class M1695 {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> preMap = new HashMap<>();
        int ans = 0;
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer preIndex = preMap.getOrDefault(nums[i], -1);
            if (preIndex < pre) {
                cur = cur + nums[i];
                ans = Math.max(ans, cur);
            } else {
                for (int j = Math.max(pre, 0); j < preIndex; j++) {
                    cur -= nums[j];
                }
                pre = preIndex + 1;
            }
            preMap.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        M1695 solve = new M1695();
        int[] nums = {4, 2, 4, 5, 6};
//        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
//        int[] nums = {10000, 1, 10000, 1, 1, 1, 1, 1, 1};

        int res = solve.maximumUniqueSubarray(nums);
        System.out.println(res);
    }
}
