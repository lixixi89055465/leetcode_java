package leetcode.a2800;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： li
 * @date： 2024/9/4 10:18
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 2860. 让所有学生保持开心的分组方法数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。
 * 班主任希望能够在让所有学生保持开心的情况下选出一组学生：
 * <p>
 * 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
 * <p>
 * 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
 * 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
 * 返回能够满足让所有学生保持开心的分组方法的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1]
 * 输出：2
 * 解释：
 * 有两种可行的方法：
 * 班主任没有选中学生。
 * 班主任选中所有学生形成一组。
 * 如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
 * 示例 2：
 * <p>
 * 输入：nums = [6,0,3,3,6,7,2,7]
 * 输出：3
 * 解释：
 * 存在三种可行的方法：
 * 班主任选中下标为 1 的学生形成一组。
 * 班主任选中下标为 1、2、3、6 的学生形成一组。
 * 班主任选中所有学生形成一组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 */
public class M2860countWays {
    static class Solution {
        public int countWays(List<Integer> nums) {
            if (nums == null || nums.isEmpty()) {
                return 0;
            }
            Collections.sort(nums);
            int minQ = nums.get(0);
            int res = 0;
            if (nums.get(0) > 0) {
                res++;
            }
            int maxQ = Integer.MAX_VALUE;
            for (int i = 0; i < nums.size() - 1; i++) {
                maxQ = nums.get(i);
                if (maxQ < i + 1 && nums.get(i + 1) > i + 1) {
                    res++;
                }
            }
            if (nums.get(nums.size()-1) < nums.size()) {
                res++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7);
//        List<Integer> nums = Arrays.asList(1, 1);
        Solution solve = new Solution();
        int result = solve.countWays(nums);
        System.out.println(result);
    }
}
